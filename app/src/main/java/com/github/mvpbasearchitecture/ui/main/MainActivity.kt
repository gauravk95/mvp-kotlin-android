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

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import com.github.mvpbasearchitecture.R
import com.github.mvpbasearchitecture.base.BaseActivity
import com.github.mvpbasearchitecture.utils.ext.applyFontForToolbarTitle
import com.github.mvpbasearchitecture.utils.ext.findFragmentById
import com.github.mvpbasearchitecture.utils.ext.setFragment

/**
 * The main activity the application when launched
 *
 * Created by gk
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()

        val mainFragment: MainFragment? = findFragmentById(R.id.content_frame)
        if (mainFragment == null)
           setFragment( MainFragment.newInstance(), R.id.content_frame)

    }

    private fun setupToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_white)
        supportActionBar?.title = getText(R.string.toolbar_title)

        toolbar.applyFontForToolbarTitle()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
