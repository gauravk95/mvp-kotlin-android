/*
    Copyright 2018 Gaurav Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.github.mvpbasearchitecture.data.source.repository

import android.support.annotation.VisibleForTesting

import com.github.mvpbasearchitecture.data.models.local.Item
import com.github.mvpbasearchitecture.data.source.prefs.PreferencesHelper
import com.github.mvpbasearchitecture.di.Local
import com.github.mvpbasearchitecture.di.Remote

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Flowable

/**
 * The central point to communicate to different data sources like DB, SERVER, SHARED PREFS
 *
 * Created by gk
 */

@Singleton
class AppDataRepository @Inject
constructor(@param:Remote private val mRemoteAppDataSource: AppDataSource,
            @param:Local private val mLocalAppDataSource: AppDataSource,
            private val mPreferenceHelper: PreferencesHelper) : AppRepository {

    @VisibleForTesting
    internal var mCachedItemList: List<Item>? = null

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    @VisibleForTesting
    internal var mCacheIsDirty = false

    //get the items from the server
    private fun getItemFromServerDB(): Flowable<List<Item>> {
        return mRemoteAppDataSource
                .getItemList()
                .doOnNext { items ->
                    mLocalAppDataSource.updateItemList(items)
                    mCachedItemList = items
                    mCacheIsDirty = false
                }
    }

    //get the elements from local db, and if empty get it from sever
    private fun getItemFromLocalDB(): Flowable<List<Item>> {
        return mLocalAppDataSource
                .getItemList()
                .switchIfEmpty(getItemFromServerDB())
                .flatMap { items ->
                    val tempItems: Flowable<List<Item>>
                    if (items.isNotEmpty()) {
                        mCachedItemList = items
                        mCacheIsDirty = false
                        tempItems = Flowable.just(items)
                    } else {
                        mCacheIsDirty = true
                        tempItems = getItemFromServerDB()
                    }
                    return@flatMap tempItems
                }
    }

    override fun getItemList(forceRemote: Boolean): Flowable<List<Item>> {
        return if (forceRemote) getItemFromServerDB() else getItemList()
    }

    override fun getItemList(): Flowable<List<Item>> {
        // Respond immediately with cache if available and not dirty
        if (mCachedItemList != null && !mCacheIsDirty) {
            return Flowable.just(mCachedItemList!!)
        }

        //if cache is dirty, get the data from server
        return if (mCacheIsDirty) getItemFromServerDB() else getItemFromLocalDB()
    }

    override fun updateItemList(items: List<Item>) {
        mLocalAppDataSource.updateItemList(items)
    }

    override fun refreshItems() {
        mCacheIsDirty = true
    }
}
