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

import com.github.mvpbasearchitecture.BuildConfig
import com.github.mvpbasearchitecture.data.source.network.APIService
import com.github.mvpbasearchitecture.data.source.network.NetworkAPIs
import com.github.mvpbasearchitecture.data.source.network.NetworkUtils
import com.github.mvpbasearchitecture.data.source.network.APIHelper
import com.github.mvpbasearchitecture.utils.AppConstants

import java.util.concurrent.TimeUnit

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Modules related to network
 *
 * Created by gk.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCall(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(NetworkUtils.httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofitHelper(apiHelper: APIHelper): NetworkAPIs {
        return apiHelper
    }

}
