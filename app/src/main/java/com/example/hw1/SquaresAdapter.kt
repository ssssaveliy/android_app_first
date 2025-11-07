package com.example.hw1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class SquaresAdapter : RecyclerView.Adapter<SquareViewHolder>() {

    private val items = ArrayList<Item>()

    fun setItems(newItems: List<Item>) {
        val diff = DiffUtil.calculateDiff(ItemDiffCallback(items, newItems))
        items.clear()
        items.addAll(newItems)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_square, parent, false)
        return SquareViewHolder(v)
    }

    override fun onBindViewHolder(holder: SquareViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item.text, item.colorRes)
    }

    override fun getItemCount() = items.size
}
