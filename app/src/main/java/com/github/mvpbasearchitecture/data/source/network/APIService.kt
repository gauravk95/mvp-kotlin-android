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
package com.github.mvpbasearchitecture.data.source.network

import com.github.mvpbasearchitecture.data.models.remote.ResponseItemHolder

import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Retrofit API services to connect to server
 *
 * Created by gk
 */

interface APIService {

    @GET("getItemList")
    fun getItemList(): Flowable<ResponseItemHolder>

}
