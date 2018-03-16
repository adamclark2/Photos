package com.example.noahr.android.Service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by noahr on 3/16/2018.
 */

interface ImageEndpoints {

    /*
        Get a list of the URLs of the images stored remotely
     */
    @GET("{images}")
    fun getImages(): Call<List<String>>
}
