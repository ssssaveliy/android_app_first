package com.example.hw1

data class Item(val index: Int) {
    val text: String
        get() = index.toString()

    val colorRes: Int
        get() = if (index % 2 == 0) R.color.redItem else R.color.blueItem
}

