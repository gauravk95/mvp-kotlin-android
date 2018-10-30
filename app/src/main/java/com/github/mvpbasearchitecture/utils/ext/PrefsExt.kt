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
package com.github.mvpbasearchitecture.utils.ext

import android.content.SharedPreferences

/*******************************************
 * Extension Functions or shared preferences
 *
 * Created by gk
 *******************************************/

//clears all the shared prefs
fun SharedPreferences.clearSharedPrefs() {
    edit().clear().apply()
}

fun SharedPreferences.getLongSharedPref(key: String): Long {
    return getLong(key, 0)
}

fun SharedPreferences.setLongSharedPref(key: String, value: Long) {
    edit().putLong(key, value).apply()
}

fun SharedPreferences.getIntSharedPref(key: String): Int {
    return getInt(key, 0)
}

fun SharedPreferences.setIntSharedPref(key: String, value: Int) {
    edit().putInt(key, value).apply()
}

fun SharedPreferences.getBooleanSharedPref(key: String): Boolean {
    return getBoolean(key, false)
}

fun SharedPreferences.setBooleanSharedPref(key: String, value: Boolean) {
    edit().putBoolean(key, value).apply()
}

fun SharedPreferences.getStringSharedPref(key: String): String {
    return getString(key, "")
}

fun SharedPreferences.setStringSharedPref(key: String, value: String) {
    edit().putString(key, value).apply()
}
