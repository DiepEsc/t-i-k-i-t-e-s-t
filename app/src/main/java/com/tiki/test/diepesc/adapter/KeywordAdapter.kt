package com.tiki.test.diepesc.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tiki.test.diepesc.R

class KeywordAdapter(private val keywords: List<String>) : RecyclerView.Adapter<KeywordViewHolder>() {
    val colors = ArrayList<Int>()

    init {
        for (keword in keywords) {
            var color = (Math.random() * 0xffffff).toInt()
            color = Color.argb(0xe4, color shr 16, color shr 8, color)
            colors.add(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyword, parent, false)
        return KeywordViewHolder(view)
    }

    override fun getItemCount() = keywords.size

    override fun onBindViewHolder(holder: KeywordViewHolder, position: Int) {
        val keyword = keywords[position]
        val color = colors[position]
        holder.bindData(keyword, color)
    }
}
