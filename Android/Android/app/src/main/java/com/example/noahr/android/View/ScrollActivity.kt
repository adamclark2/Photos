package com.example.noahr.android.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.noahr.android.R
import android.widget.GridView
import android.widget.ArrayAdapter
import com.example.noahr.android.Adapter.ImageAdapter
import com.example.noahr.android.Service.ImageNetworkService
import com.example.noahr.android.Service.ImageNetworkServiceRetrofit


class ScrollActivity : AppCompatActivity() {

    private var arrayAdapter: ArrayAdapter<*>? = null
    private var imageAdapter: ImageAdapter? = null
    private var gridView: GridView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        /*
            Delegate the task of gathering images from a remote server to the ImageNetworkService
         */
        var imageNetworkService: ImageNetworkService = ImageNetworkServiceRetrofit(applicationContext, arrayAdapter, gridView, imageAdapter)
        imageNetworkService.getImages();
    }
}
