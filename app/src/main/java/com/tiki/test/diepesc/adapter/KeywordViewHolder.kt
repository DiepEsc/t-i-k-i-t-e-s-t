package com.tiki.test.diepesc.adapter

import android.graphics.Color
import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.View
import com.tiki.test.diepesc.R

class KeywordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView: AppCompatTextView = itemView as AppCompatTextView
    fun bindData(keyword: String, @ColorInt color: Int) {
        textView.text = keyword
        var drawable = ContextCompat.getDrawable(itemView.context, R.drawable.bg_keyword)
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable)
            DrawableCompat.setTint(drawable, color)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                textView.background = drawable
            } else {
                textView.setBackgroundDrawable(drawable)
            }
        }
    }
}
