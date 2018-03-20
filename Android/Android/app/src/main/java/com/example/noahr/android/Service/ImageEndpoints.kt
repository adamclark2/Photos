package com.example.noahr.android.Service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by noahr on 3/16/2018.
 */

interface ImageEndpoints {

    /**
     * Return the URLs of all the images stored remotely
     */
    @GET("imageurls")
    fun getImages(): Call<List<String>>
}
