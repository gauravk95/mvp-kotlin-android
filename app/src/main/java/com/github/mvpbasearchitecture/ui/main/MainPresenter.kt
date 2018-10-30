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
package com.github.mvpbasearchitecture.ui.main

import com.github.mvpbasearchitecture.base.BasePresenter
import com.github.mvpbasearchitecture.data.models.local.Item
import com.github.mvpbasearchitecture.data.source.repository.AppRepository
import com.github.mvpbasearchitecture.utils.rx.SchedulerProvider

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Main Fragment where most of the UI stuff happens
 * Extends functionality of [BasePresenter]
 * Implements Screen specific Presenter tasks [MainContract.Presenter]
 *
 *
 * Created by gk
 */
class MainPresenter @Inject
constructor(appRepository: AppRepository,
            schedulerProvider: SchedulerProvider,
            compositeDisposable: CompositeDisposable) :
            BasePresenter<MainContract.View>(appRepository, schedulerProvider, compositeDisposable),
            MainContract.Presenter {

    private var mDisposable: Disposable? = null

    override fun loadItems(refresh: Boolean) {
        view?.showProgressDialog()

        if (refresh)
            dataSource.refreshItems()

        //remove the previous disposable from composite disposable, for multiple load items calls
        if (mDisposable != null)
            compositeDisposable.delete(mDisposable!!)

        mDisposable = dataSource.getItemList()
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
                .subscribe({ items: List<Item> ->
                    if (!isViewAttached)
                        return@subscribe

                    view?.dismissProgressDialog()
                    if (items.isNotEmpty())
                        view?.refreshItemList(items)
                    else
                        view?.showEmptyListUI()
                }, { throwable: Throwable? ->
                    if (!isViewAttached)
                        return@subscribe

                    view?.dismissProgressDialog()
                    handleApiError(throwable)
                })

        compositeDisposable.add(mDisposable!!)
    }

}
