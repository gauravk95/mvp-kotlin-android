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

import android.content.Context
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.bumptech.glide.signature.StringSignature
import com.github.mvpbasearchitecture.R

/**
 * Utilities for other general stuffs
 *
 * Created by gk
 */

object GeneralUtils {

    fun checkStringNotEmpty(str: String?): Boolean {
        return str != null && str != ""
    }

    fun loadImageFromLink(context: Context, pic: ImageView, link: String) {
        if (GeneralUtils.checkStringNotEmpty(link)) {
            Glide.with(context.applicationContext)
                    .load(link)
                    .signature(StringSignature(link))
                    .dontAnimate()
                    .placeholder(R.drawable.ic_image)
                    .into(pic)
        }
    }

}
