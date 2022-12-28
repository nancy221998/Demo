package com.amaze.demoproject.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaze.demoproject.R
import com.amaze.demoproject.activity.FullLengthImageActivity
import com.amaze.demoproject.modal.ImageModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_item.view.*
import java.util.ArrayList

class ImageListAdapter
    (imageList: MutableList<ImageModel>, context: Context)
    : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {
    var context: Context
    var imageList: MutableList<ImageModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false))
        }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
       var bean=imageList.get(i)
             Picasso.with(context).load(imageList.get(i).image.get(0)).resize(600,600).into(holder.imageView)
             holder.nameTv.text=bean.name
             holder.titleTv.text=bean.title
             holder.dateTv.text="Date : " +bean.date

                if(bean.image.size>1){
                    holder.leftImageCount.text= (bean.image.size).toString()
                    holder.leftImageCount.visibility=View.VISIBLE
                }else{
                    holder.leftImageCount.visibility=View.GONE
                }

            holder.imageView.setOnClickListener(){
                  var intent = Intent(context, FullLengthImageActivity::class.java).apply {
                    putExtra("imageList",Gson().toJson(imageList.get(i)))
                }
                context.startActivity(intent)
            }
        }

    fun updateAdapter(temp: MutableList<ImageModel>) {
        imageList=temp
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv = itemView.titleTv
        val nameTv = itemView.nameTv
        val dateTv = itemView.dateTv
        val imageView = itemView.imageView
        val leftImageCount=itemView.leftImageCount
    }

    init {
        this.imageList = imageList
        this.context = context
    }
}
