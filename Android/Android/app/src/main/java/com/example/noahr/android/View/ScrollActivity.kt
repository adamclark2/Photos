package com.example.noahr.android.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.noahr.android.R
import android.widget.GridView
import android.widget.ArrayAdapter
import com.example.noahr.android.Adapter.ImageAdapter
import com.example.noahr.android.Service.ImageNetworkService
import com.example.noahr.android.Service.ImageNetworkServiceRetrofit
import kotlinx.android.synthetic.main.activity_scroll.*

/*
The main screen/controller for the loading and displaying of images to the user
 */
class ScrollActivity : AppCompatActivity() {

    lateinit var imageNetworkService: ImageNetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        // Connect the gridview ref to the actually UI element, then create an array adapter
        // and hook it up with the gridview.
        var gridView: GridView = gridview_xml
        var arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        gridView.adapter = arrayAdapter
        var imageAdapter: ImageAdapter? = null

        // Delegate the task of gathering images from a remote server to the ImageNetworkService.
        // In this case we are utilizing the Retrofit implementation.
        imageNetworkService = ImageNetworkServiceRetrofit(applicationContext, gridView, imageAdapter)
        imageNetworkService.getImages();
    }
}
