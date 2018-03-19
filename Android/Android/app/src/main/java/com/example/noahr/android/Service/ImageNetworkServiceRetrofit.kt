package com.example.noahr.android.Service

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListAdapter
import android.widget.Toast

import com.example.noahr.android.Adapter.ImageAdapter

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by noahr on 3/16/2018.
 */

// This class is an implementation of the 'ImageNetworkService' interface.  This specific implementation
// involves making rest calls using Retrofit, a cool async HTTP library.
class ImageNetworkServiceRetrofit(internal var context: Context, internal var gridView: GridView, internal var imageAdapter: ImageAdapter?) : ImageNetworkService {
    internal var retrofit: Retrofit
    internal var endpoints: ImageEndpoints

    // Initialize the retrofit instance by connecting it to our endpoints.  Then we can create a
    // working object out of the interface.
    init {
        val BASE_URL = "http://10.0.2.2:8080/"
        this.retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        this.endpoints = retrofit.create(ImageEndpoints::class.java)
    }

    // Get a list of the URLs of the images stored remotely
    override fun getImages() {
        val call = endpoints.getImages()
        call.enqueue(object : Callback<List<String>> {

            // Once we get the async response, we grab the list of URLs from the server, and stuff
            // them into an image adapter and display the images in the UI.
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.body() != null) {
                    val imageUrls = response.body() as ArrayList<String>?
                    imageAdapter = ImageAdapter(context, imageUrls)
                    gridView.adapter = imageAdapter
                } else {
                    // Empty response lol!
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {

            }
        })
    }
}
