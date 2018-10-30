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
package com.github.mvpbasearchitecture.data.source.prefs

import android.content.Context
import android.content.SharedPreferences

import com.github.mvpbasearchitecture.di.ApplicationContext
import com.github.mvpbasearchitecture.di.PreferenceInfo

import com.github.mvpbasearchitecture.utils.ext.getBooleanSharedPref
import com.github.mvpbasearchitecture.utils.ext.getIntSharedPref
import com.github.mvpbasearchitecture.utils.ext.getStringSharedPref
import com.github.mvpbasearchitecture.utils.ext.getLongSharedPref
import com.github.mvpbasearchitecture.utils.ext.setBooleanSharedPref
import com.github.mvpbasearchitecture.utils.ext.setIntSharedPref
import com.github.mvpbasearchitecture.utils.ext.setStringSharedPref
import com.github.mvpbasearchitecture.utils.ext.setLongSharedPref

import javax.inject.Inject
import javax.inject.Singleton

/**
 * An Helper class for Shared Preferences
 *
 * Created by gk.
 */

@Singleton
class AppPreferences @Inject
constructor(@ApplicationContext context: Context,
            @PreferenceInfo prefFileName: String) : Preferences {

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getBoolean(key: String): Boolean {
        return mPrefs.getBooleanSharedPref(key)
    }

    override fun getLong(key: String): Long {
        return mPrefs.getLongSharedPref(key)
    }

    override fun getInt(key: String): Int {
        return mPrefs.getIntSharedPref(key)
    }

    override fun getString(key: String): String {
        return mPrefs.getStringSharedPref(key)
    }

    override fun setBoolean(key: String, value: Boolean) {
        mPrefs.setBooleanSharedPref(key, value)
    }

    override fun setLong(key: String, value: Long) {
        mPrefs.setLongSharedPref(key, value)
    }

    override fun setInt(key: String, value: Int) {
        mPrefs.setIntSharedPref(key, value)
    }

    override fun getString(key: String, value: String) {
        mPrefs.setStringSharedPref(key, value)
    }

}
