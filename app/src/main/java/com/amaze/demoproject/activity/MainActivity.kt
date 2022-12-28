package com.amaze.demoproject.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaze.demoproject.R
import com.amaze.demoproject.adapter.ImageListAdapter
import com.amaze.demoproject.modal.DummyData
import com.amaze.demoproject.modal.ImageModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import com.google.android.material.snackbar.Snackbar

import android.widget.CompoundButton
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.custom_toolbar.*
import androidx.recyclerview.widget.LinearSnapHelper

import android.R.string.no
import com.amaze.demoproject.util.setStatusBarColor

    class MainActivity : AppCompatActivity() {

       var imageModel : MutableList<ImageModel> = ArrayList()
       var searchImageList : MutableList<ImageModel> = ArrayList()
       lateinit var  imageListAdapter:  ImageListAdapter
       var layoutType=1

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        setStatusBarColor(this)
        init()
        }

    fun init(){
        addItemInList()
          checkImage.setOnClickListener(){
            filter(searchEt.text.toString())
            searchEt.setText("")
            searchEt.hint="Search by title.."
        }

        switchButton.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
               layoutType=2
            }else{
                layoutType=1
            }
            setDataInList()
        })
    }

    fun filter(text: String) {
         val temp: MutableList<ImageModel> = ArrayList<ImageModel>()
        if(imageModel.size>0) {
            for (d in imageModel) {
                if (d.name.toLowerCase().contains(text.toLowerCase()) || d.date.toLowerCase()
                        .contains(text.toLowerCase())
                 ) {
                    temp.add(d)
                    if(d.name.toLowerCase().equals(text.toLowerCase())){
                        if(!searchImageList.contains(d))
                        {
                            searchImageList.add(d)
                            setDataInList()
                        }
                     }
                }
            }
            recycleList.visibility=View.VISIBLE
            hintText.visibility=View.GONE
        }
    }

    private fun addItemInList() {
         imageModel= DummyData.getDummyData(this)
         setDataInList()
        }

    fun setDataInList(){
        Log.d("searchImageList",searchImageList.size.toString())
         recycleList.apply {
             if(layoutType==1){
                 layoutManager= LinearLayoutManager(this@MainActivity)
             }else{
                 layoutManager= GridLayoutManager(this@MainActivity,2)
             }

             imageListAdapter= ImageListAdapter(searchImageList.asReversed(),this@MainActivity)
             adapter=imageListAdapter
            isNestedScrollingEnabled=false
         }
    }



}