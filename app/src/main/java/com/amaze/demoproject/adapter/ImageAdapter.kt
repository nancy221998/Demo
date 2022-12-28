package com.amaze.demoproject.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaze.demoproject.R
import com.amaze.demoproject.modal.ImageModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_item.view.*
import java.util.ArrayList

class ImageAdapter
    (imageList: MutableList<String>, context: Context)
    : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    var context: Context
    var imageList: MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.single_image_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        Picasso.with(context).load(imageList.get(i)).resize(600,600).into(holder.imageView)
     }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val imageView = itemView.imageView
     }

    init {
        this.imageList = imageList
        this.context = context
    }
}
