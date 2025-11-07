package com.example.hw1

import android.content.res.Configuration
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

        val span = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            resources.getInteger(R.integer.span_portrait)
        else
            resources.getInteger(R.integer.span_landscape)
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

        val initialCount = resources.getInteger(R.integer.initial_count)
        val count = savedInstanceState?.getInt("count") ?: initialCount
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
