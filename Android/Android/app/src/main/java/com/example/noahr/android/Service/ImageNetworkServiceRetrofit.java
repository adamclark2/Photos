package com.example.noahr.android.Service;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.noahr.android.Adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by noahr on 3/16/2018.
 */

// This class is an implementation of the 'ImageNetworkService' interface.  This specific implementation
// involves making rest calls using Retrofit, a cool async HTTP library.
public class ImageNetworkServiceRetrofit implements ImageNetworkService {
    Retrofit retrofit;
    ImageEndpoints endpoints;
    ArrayAdapter arrayAdapter;
    GridView gridView;
    ImageAdapter imageAdapter;
    Context context;

    public ImageNetworkServiceRetrofit(Context con, ArrayAdapter arrayAdapter, GridView gridView, ImageAdapter imageAdapter){
        this.context = con;
        final String BASE_URL = "http://localhost:8080/";
        this.retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        this.endpoints = retrofit.create(ImageEndpoints.class);
        this.gridView = gridView;
        this.arrayAdapter = arrayAdapter;
        this.imageAdapter = imageAdapter;
    }

    // Get a list of the URLs of the images stored remotely
    @Override
    public void getImages() {
        Call<List<String>> call = endpoints.getImages();
        call.enqueue(new Callback<List<String>>() {

            // Once we get the async response, we grab the list of URLs from the server, and stuff
            // them into an image adapter and display the images in the UI.
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(response.body() != null){
                    List<String> imageUrls = response.body();

                    // *** FOR TESTING!!! ***
                    imageUrls.add("fakeUrlOne");
                    imageUrls.add("fakeUrlTwo");
                    imageUrls.add("fakeUrlThree");

                    imageAdapter = new ImageAdapter(context, imageUrls);
                    gridView.setAdapter(imageAdapter);
                }
                else{
                    // Empty response lol!
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }
}
