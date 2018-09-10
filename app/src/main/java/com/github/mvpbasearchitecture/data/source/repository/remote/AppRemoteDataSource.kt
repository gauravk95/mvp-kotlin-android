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
package com.github.mvpbasearchitecture.data.source.repository.remote

import com.github.mvpbasearchitecture.data.models.local.Item
import com.github.mvpbasearchitecture.data.models.remote.ResponseItemHolder
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource
import com.github.mvpbasearchitecture.data.source.network.NetworkAPIs

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Flowable

/**
 * Concrete implementation of a data source from remote server, using retrofit
 *
 * Created by gk
 */

@Singleton
class AppRemoteDataSource @Inject
constructor(private val mNetworkAPIs: NetworkAPIs) : AppDataSource {

    override fun getItemList(): Flowable<List<Item>> {
        return mNetworkAPIs.getAPIService()
                .getItemList()
                .map { t: ResponseItemHolder -> t.itemList}
    }

    override fun updateItemList(items: List<Item>) {
        //do nothing
    }
}