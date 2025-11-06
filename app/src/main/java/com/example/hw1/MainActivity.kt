package com.example.hw1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = SquaresAdapter()
    private val items = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        val span = if (resources.configuration.orientation ==
            android.content.res.Configuration.ORIENTATION_PORTRAIT) 3 else 4
        recyclerView.layoutManager = GridLayoutManager(this, span)
        recyclerView.adapter = adapter

        val bottomInset = resources.getDimensionPixelSize(R.dimen.list_bottom_inset)
        recyclerView.setPadding(
            recyclerView.paddingLeft,
            recyclerView.paddingTop,
            recyclerView.paddingRight,
            bottomInset
        )
        recyclerView.clipToPadding = false

        val count = savedInstanceState?.getInt("count") ?: 9
        items.clear()
        repeat(count) { items += Item(it) }
        adapter.setItems(items)

        fab.setOnClickListener {
            items += Item(items.size)
            adapter.setItems(items)
            recyclerView.smoothScrollToPosition(items.lastIndex)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", items.size)
        super.onSaveInstanceState(outState)
    }
}
