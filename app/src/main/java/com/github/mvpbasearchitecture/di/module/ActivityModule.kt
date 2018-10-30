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
package com.github.mvpbasearchitecture.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity

import com.github.mvpbasearchitecture.data.source.repository.AppRepository
import com.github.mvpbasearchitecture.di.ActivityContext
import com.github.mvpbasearchitecture.ui.main.MainContract
import com.github.mvpbasearchitecture.ui.main.MainPresenter
import com.github.mvpbasearchitecture.utils.rx.AppSchedulerProvider
import com.github.mvpbasearchitecture.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Modules related to activity
 *
 * Created by gk.
 */

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): AppCompatActivity {
        return activity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    fun provideMainPresenter(appRepository: AppRepository,
                                      schedulerProvider: SchedulerProvider,
                                      compositeDisposable: CompositeDisposable): MainContract.Presenter {
        return MainPresenter(appRepository, schedulerProvider, compositeDisposable)
    }

}
