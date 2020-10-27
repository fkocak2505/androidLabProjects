package com.example.paginationwithrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_style.view.*


class RecyclerViewAdapter(private val items: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHoldere>() {

    //var onBottomReachedListener: OnBottomReachedListener? = null

    fun addItems(items: ArrayList<String>) {
        var size = items.size + 1
        this.items.addAll(items)
        var sizeNew = this.items.size
        //notifyDataSetChanged()
        notifyItemRangeInserted(sizeNew, size)

    }

    /*fun dendede(onBottomReachedListener: OnBottomReachedListener) {
        this.onBottomReachedListener = onBottomReachedListener
    }*/

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

        /*if (position == items.size - 1) {

            onBottomReachedListener?.onBottomReached(position)

        }*/

        holder.itemTextView.text = items[position]

        Picasso.get().load("https://img-s2.onedio.com/id-596a3adbac6b91a7196c6361/rev-0/w-900/h-500/f-jpg/s-b7a766fe19b6d1e8ed26a7a2c6f19d9e3d99f647.jpg")
            .into(holder.imageView, object : Callback {
                override fun onSuccess() {
                    holder.foodCoverPhotoProgress.visibility = View.INVISIBLE
                }

                override fun onError(e: Exception?) {
                    holder.foodCoverPhotoProgress.visibility = View.VISIBLE
                }
            })
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHoldere(view: View) : RecyclerView.ViewHolder(view) {
        val itemTextView: TextView = view.tvItem
        val foodCoverPhotoProgress: ProgressBar = view.foodCoverPhotoProgress
        val imageView: ImageView = view.imageView

    }


   /* interface OnBottomReachedListener {

        fun onBottomReached(position: Int)

    }
*/

}