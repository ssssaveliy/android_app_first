package com.example.hw1

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SquareViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val label: TextView = view.findViewById(R.id.label)
    fun bind(index: Int, isEven: Boolean) {
        label.text = index.toString()
        val color = if (isEven) R.color.redItem else R.color.blueItem
        label.setBackgroundColor(
            ContextCompat.getColor(itemView.context, color)
        )
    }
}
