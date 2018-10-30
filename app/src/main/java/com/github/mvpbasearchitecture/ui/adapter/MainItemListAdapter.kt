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
package com.github.mvpbasearchitecture.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.github.mvpbasearchitecture.R
import com.github.mvpbasearchitecture.data.models.local.Item
import com.github.mvpbasearchitecture.utils.ext.loadImageFromLink

/**
 * Adapter that used to display [Item] in a recycler view
 *
 * Created by gk
 */
class MainItemListAdapter(
        private val context: Context?,
        private val items: List<Item>) :
        RecyclerView.Adapter<MainItemListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.id.text = item.id
        holder.name.text = item.name
        holder.image.loadImageFromLink(item.imageLink)
    }

    override fun getItemCount(): Int = items.size

    /**
     * View Holder for recycler view.
     */
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.item_image)
        var id: TextView = itemView.findViewById(R.id.item_id)
        var name: TextView = itemView.findViewById(R.id.item_name)
    }

}