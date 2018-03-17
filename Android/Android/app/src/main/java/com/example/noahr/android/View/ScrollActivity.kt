package com.example.noahr.android.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.noahr.android.R
import android.widget.GridView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.example.noahr.android.Adapter.ImageAdapter
import com.example.noahr.android.Service.ImageNetworkService
import com.example.noahr.android.Service.ImageNetworkServiceRetrofit
import kotlinx.android.synthetic.main.activity_scroll.*


class ScrollActivity : AppCompatActivity() {

    private var arrayAdapter: ArrayAdapter<*>? = null
    private var imageAdapter: ImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
        // Set up the initial gridview for the main screen
        var gridView: GridView = findViewById(R.id.gridview_xml)
        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        gridView.adapter = arrayAdapter

        /*
            Delegate the task of gathering images from a remote server to the ImageNetworkService
         */
        var imageNetworkService: ImageNetworkService = ImageNetworkServiceRetrofit(applicationContext, arrayAdapter, gridView, imageAdapter)
        imageNetworkService.getImages();
    }
}
