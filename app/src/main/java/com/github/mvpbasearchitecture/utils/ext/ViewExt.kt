package com.github.mvpbasearchitecture.utils.ext

import android.graphics.Color
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.StringSignature
import com.github.mvpbasearchitecture.R
import com.github.mvpbasearchitecture.utils.font.CustomTypeface


/*******************************************
 * View Extension Function
 *
 * Created by gk
 ******************************************/

/**
 * Make the view visible
 */
fun View.toVisible() {
    visibility = View.VISIBLE
}

/**
 * Make the view invisible
 */
fun View.toInvisible() {
    visibility = View.INVISIBLE
}

/**
 * Make the view gone
 */
fun View.toGone() {
    visibility = View.GONE
}

/**
 * Loads the Image from [link] into ImageView
 */
fun ImageView.loadImageFromLink(link: String?) {
    if (!link.isNullOrEmpty())
        Glide.with(context.applicationContext)
                .load(link)
                .signature(StringSignature(link))
                .dontAnimate()
                .placeholder(R.drawable.ic_image)
                .into(this)
}


/**
 * Extension Function to change the font
 */
fun Toolbar.applyFontForToolbarTitle() {
    for (i in 0 until childCount) {
        val view = getChildAt(i)
        if (view is TextView) {
            val titleFont = CustomTypeface[context.assets, "fonts/OpenSans-SemiBold.ttf"]
            if (view.text == title) {
                view.typeface = titleFont
                view.setTextColor(Color.WHITE)
                view.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.toolbar_title))
                break
            }
        }
    }
}