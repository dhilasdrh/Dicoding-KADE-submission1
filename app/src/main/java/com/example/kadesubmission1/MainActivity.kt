package com.example.kadesubmission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        recyclerView {
            lparams(width = matchParent, height = wrapContent)
            layoutManager = GridLayoutManager(context, 2)
            adapter = RecyclerViewAdapter(items) {
                startActivity<DetailActivity>("EXTRA_ITEM" to it)
            }
        }
    }

    private fun initData() {
        val image = resources.obtainTypedArray(R.array.league_img)
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],image.getResourceId(i, 0),desc[i]))
        }
        image.recycle()
    }
}
