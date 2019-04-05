package com.example.recyclerviewwithpages

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PagedRecViewAdapter(val number_of_items: Int) : RecyclerView.Adapter<PagedRecViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_layout, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.text = "position " + p1
    }


    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return number_of_items
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.item_layout_textview)
    }
}