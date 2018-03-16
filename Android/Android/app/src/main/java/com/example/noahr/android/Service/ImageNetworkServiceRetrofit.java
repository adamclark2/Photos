package com.example.noahr.android.Service;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by noahr on 3/16/2018.
 */

public class ImageNetworkServiceRetrofit implements ImageNetworkService {
    Retrofit retrofit;
    ImageEndpoints endpoints;
    ArrayAdapter vArrayAdapter;
    GridView gridView;
    //ImageAdapter imageAdapter;
    Context context;

    public ImageNetworkServiceRetrofit(Context con){
        this.context = con;
        final String BASE_URL = "BASE_URL_GOES_HERE!!!";
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        endpoints = retrofit.create(ImageEndpoints.class);
    }

    /*
        Get a list of the URLs of the images stored remotely
     */
    @Override
    public void getImages() {
        Call<List<String>> call = endpoints.getImages();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }
}
