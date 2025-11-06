package com.example.hw1

import androidx.recyclerview.widget.DiffUtil


class ItemDiffCallback(
    val oldItems: ArrayList<Item>,
    val newItems: List<Item>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size
    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldPos: Int, newPos: Int) =
        oldItems[oldPos] == newItems[newPos]

    override fun areContentsTheSame(oldPos: Int, newPos: Int) =
        oldItems[oldPos] == newItems[newPos]
}