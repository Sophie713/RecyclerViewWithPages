package com.example.recyclerviewwithpages


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Sophie on 2/28/2019.
 */
class PageNumbersAdapter(val numberOfPages: Int) : RecyclerView.Adapter<PageNumbersAdapter.ViewHolder>() {

    var chosen_number = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_page_number, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.page_number.context
        if(position == chosen_number){
            holder.page_number.setBackgroundResource(R.drawable.bckg_card_background_chosen)
        } else {
            holder.page_number.setBackgroundResource(R.drawable.bckg_card_background)
        }
        holder.page_number.setText((position+1).toString())
        holder.page_number.setOnClickListener {
            chosen_number = position
            //TODO post to change teh page
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return numberOfPages
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var page_number: TextView

        init {
            page_number = itemView.findViewById(R.id.layout_page_number_number)

        }
    }

    public fun setCataloguePage(int: Int){
        chosen_number = int
        notifyDataSetChanged()
    }

}