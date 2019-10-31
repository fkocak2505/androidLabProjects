package com.example.paginationwithrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_style.view.*

class RecyclerViewAdapter(private val items: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHoldere>() {

    fun addItems(items: ArrayList<String>) {
        this.items.addAll(items)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHoldere {
        return ViewHoldere(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_style,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHoldere, position: Int) {
        holder.itemTextView.text = items?.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHoldere(view: View) : RecyclerView.ViewHolder(view) {
        val itemTextView: TextView = view.itemTextView
    }

}