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
package com.github.mvpbasearchitecture.utils

import android.util.Log

import com.github.mvpbasearchitecture.BuildConfig

/**
 * An App logger to only log in Debug mode
 *
 * Created by gk
 */

class AppLogger {

    companion object {

        var isDebugMode = true

        fun init() {
            if (!BuildConfig.DEBUG) {
                isDebugMode = false
            }
        }

        // For Debug Messages
        fun d(tag: String, msg: String) {
            if (isDebugMode)
                Log.d(tag, msg)
        }

        //For Error Messages
        fun e(tag: String, msg: String) {
            if (isDebugMode)
                Log.e(tag, msg)
        }

        //For Warning Messages
        fun w(tag: String, msg: String) {
            if (isDebugMode)
                Log.w(tag, msg)
        }

        //For Information Messages
        fun i(tag: String, msg: String) {
            if (isDebugMode)
                Log.i(tag, msg)
        }

        //For Verbose Messages
        fun v(tag: String, msg: String) {
            if (isDebugMode)
                Log.v(tag, msg)
        }

    }

}
