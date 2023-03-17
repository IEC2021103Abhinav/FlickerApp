package com.example.flicker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.GridLayout
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var imgBtn:Button?=null
    var imgRecyclerView:RecyclerView?=null

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgBtn=findViewById(R.id.img_btn)
        imgRecyclerView=findViewById(R.id.img_recycler)
        imgRecyclerView!!.layoutManager=GridLayoutManager(this,3)
        val photosViewModel:PhotosViewModel by viewModels()


        imgBtn!!.setOnClickListener {
            imgRecyclerView!!.adapter=photosViewModel.photosAdapter
            photosViewModel.loadPhotos()
                .observe(this, Observer { list->
                    with(photosViewModel.photosAdapter){
                        images.clear()
                        images.addAll(list)
                        notifyDataSetChanged()
                    }
                })

        }
    }
}

//from api key -->after request we get photo response in which we get all stuffs
//https://live.staticflickr.com/{server-id}/{id}_{o-secret}_o.{o-format}
//#
//# Example
//#   server-id: 7372
//#   photo-id: 12502775644
//#   secret: acfd415fa7
//#   size: w
//#
//https://live.staticflickr.com/7372/12502775644_acfd415fa7_w.jpg
//this is the url of a image which is made by the data of the photo response

//Flicker Tut
//Key:47d8a8614117d5cedc008a0e93320dd2
//
//Secret:8b86c66ece108dd9



//steps -->
// first-->Data Classes
//2nd-->Api Interface
//3rd-->Repository Object
//4th --> Adapter-->adding an adapter for recyclerview of the images
//5th-->photosViewModel
//6th-->Adding an observer to watch the recent photos and fetch them into the adapter
