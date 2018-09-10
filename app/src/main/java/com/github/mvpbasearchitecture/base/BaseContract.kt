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
package com.github.mvpbasearchitecture.base

import android.support.annotation.StringRes

/**
 * The base contract
 * Consists of the Presenter and View interface
 * Helps in communication/establish contract between View and Presenter
 *
 * Created by gk
 */

interface BaseContract {

    interface View<T> {

        fun setPresenter(presenter: T)

        fun showProgressDialog()

        fun dismissProgressDialog()

        fun showToastMessage(message: String?)

        fun showToastMessage(@StringRes stringResourceId: Int)

        fun showSnackBarMessage(message: String?)

        fun showSnackBarMessage(@StringRes stringResourceId: Int)

        fun onError(message: String?)

        fun onError(@StringRes resId: Int)

    }

    interface Presenter<V> {

        fun onAttach(view: V)

        fun onDetach()

        fun handleApiError(throwable: Throwable?)

    }

}
