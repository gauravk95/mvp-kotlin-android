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
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.mvpbasearchitecture.R
import com.github.mvpbasearchitecture.base.BaseMVPFragment
import com.github.mvpbasearchitecture.data.models.local.Item
import com.github.mvpbasearchitecture.ui.adapter.MainItemListAdapter
import com.github.mvpbasearchitecture.utils.ext.toGone
import com.github.mvpbasearchitecture.utils.ext.toVisible

import kotlinx.android.synthetic.main.fragment_main.*

import javax.inject.Inject

/**
 * Main Fragment where most of the UI stuff happens
 * Extends functionality of [BaseMVPFragment]
 * Implements Screen specific ui tasks [MainContract.View]
 *
 * Created by gk
 */
class MainFragment : BaseMVPFragment<MainContract.Presenter>(), MainContract.View {

    private lateinit var inflatedView: View

    @Inject
    lateinit var mainPresenter: MainContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.inflatedView = inflater.inflate(R.layout.fragment_main, container, false)
        return inflatedView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()

        val component = activityComponent
        component.inject(this)
        mainPresenter.onAttach(this)

        mainPresenter.loadItems(false)
    }

    private fun setupListeners() {
        refresh_item_btn.setOnClickListener { mainPresenter.loadItems(true) }
    }

    override fun refreshItemList(itemList: List<Item>) {
        item_recycler_view.toVisible()
        empty_list_text.toGone()

        val linearLayoutManager = LinearLayoutManager(context)
        val itemAdapter = MainItemListAdapter(context!!, itemList)

        item_recycler_view.layoutManager = linearLayoutManager
        item_recycler_view.adapter = itemAdapter
    }

    override fun showEmptyListUI() {
        item_recycler_view.toGone()
        empty_list_text.toVisible()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.mainPresenter = presenter
    }

    override fun onDestroy() {
        mainPresenter.onDetach()
        super.onDestroy()
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
