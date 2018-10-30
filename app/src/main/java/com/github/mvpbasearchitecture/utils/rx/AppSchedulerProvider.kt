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
package com.github.mvpbasearchitecture.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Helper class to provide [Schedulers] for RxJava related operations
 *
 * Created by gk.
 */

class AppSchedulerProvider : SchedulerProvider {

    override val ui: Scheduler = AndroidSchedulers.mainThread()

    override val computation: Scheduler = Schedulers.computation()

    override val io: Scheduler = Schedulers.io()

    override val trampoline: Scheduler = Schedulers.trampoline()

}
