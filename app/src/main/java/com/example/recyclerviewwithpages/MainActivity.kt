package com.example.recyclerviewwithpages

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mainRecyclerView: RecyclerView
    lateinit var gridViewLayoutManager: GridLayoutManager
    lateinit var numbersAdapter: PageNumbersAdapter
    //todo get last position
    var positions_on_one_page = 9
    val number_of_items = 150

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView = findViewById(R.id.main_recycler_view) as RecyclerView
        val numberOfColumns = 3
        gridViewLayoutManager = GridLayoutManager(this, numberOfColumns, GridLayoutManager.HORIZONTAL, false)
        mainRecyclerView.layoutManager = gridViewLayoutManager
        mainRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                //show soft disappearing edges
                if (!recyclerView.canScrollVertically(1)) {
                    val layoutManager = recyclerView.getLayoutManager() as LinearLayoutManager
                    numbersAdapter.setCataloguePage(layoutManager.findFirstCompletelyVisibleItemPosition()/positions_on_one_page)
                }
            }
        })
        val adapter = PagedRecViewAdapter(number_of_items)
        mainRecyclerView.adapter = adapter

        var full_pages = (number_of_items / positions_on_one_page)

        Log.e("xyz", "number of items: " + number_of_items)
        Log.e("xyz", "full pages: " + full_pages)
        Log.e("xyz", "full pages * positions: " + (full_pages * positions_on_one_page))

        if ((full_pages * positions_on_one_page) < (number_of_items)) {
            full_pages++
        }
        Log.e("xyz", "pages final: " + full_pages)

        numbersAdapter = PageNumbersAdapter(full_pages)
        recyclerview_with_pages.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerview_with_pages.setAdapter(numbersAdapter)
    }

}
