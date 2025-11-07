package com.example.hw1

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SquareViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val label: TextView = view.findViewById(R.id.label)
    fun bind(text: String, colorRes: Int) {
        label.text = text
        label.setBackgroundColor(
            ContextCompat.getColor(itemView.context, colorRes)
        )
    }
}
