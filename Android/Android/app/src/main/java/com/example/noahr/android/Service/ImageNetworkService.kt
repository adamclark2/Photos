package com.example.noahr.android.Service

/**
 * Created by noahr on 3/16/2018.
 */

/*
    A service that abstracts away the implementation details of the actual network calls, allowing
    the activity (view) to pass on such responsibility.
 */
interface ImageNetworkService {

    /*
        Get a list of images from a remote source
     */
    fun getImages()
}
