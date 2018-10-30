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
package com.github.mvpbasearchitecture.data.source.repository.local

import com.github.mvpbasearchitecture.data.models.local.Item
import com.github.mvpbasearchitecture.data.source.db.AppDatabase
import com.github.mvpbasearchitecture.data.source.db.ItemDao
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Flowable

/**
 * Concrete implementation of a data source as a db using room.
 */
@Singleton
class AppLocalDataSource @Inject
constructor(database: AppDatabase) : AppDataSource {

    private val itemDao: ItemDao = database.itemDao()

    override fun getItemList(): Flowable<List<Item>> {
        return itemDao.fetchItems()
    }

    override fun updateItemList(items: List<Item>) {
        itemDao.insertMultipleItem(items)
    }
}