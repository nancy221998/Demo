package com.amaze.demoproject.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.amaze.demoproject.R
import com.amaze.demoproject.adapter.ImageAdapter
import com.amaze.demoproject.modal.ImageModel
import com.amaze.demoproject.util.setStatusBarColor
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_fullimage.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class FullLengthImageActivity: AppCompatActivity()  {

    var imageList : MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullimage)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        setStatusBarColor(this)
        init()
    }

    fun init(){
        var response=Gson().fromJson(intent.getStringExtra("imageList").toString(),ImageModel::class.java)
        imagev.setOnClickListener(){finish()}
        imageList=response.image as MutableList<String>
        showImageInRecyclerview()
    }

    private fun showImageInRecyclerview() {
        imageListt.apply {
             layoutManager= LinearLayoutManager(this@FullLengthImageActivity,LinearLayoutManager.HORIZONTAL,false)
            var imageListAdapter= ImageAdapter(imageList,this@FullLengthImageActivity)
            adapter=imageListAdapter
            isNestedScrollingEnabled=false
            setOnFlingListener(null)
            var napHelper = LinearSnapHelper()
            napHelper.attachToRecyclerView(recycleList);
        }
    }
}