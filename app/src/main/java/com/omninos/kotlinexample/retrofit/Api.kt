package com.omninos.kotlinexample.retrofit

import com.omninos.kotlinexample.modelClass.ResonseClass
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @get:GET("top-headlines?country=in&apiKey=ac4f9dccb02a4335bc7b1e3fda12e7aa")
    val everthing: Call<ResonseClass>

    @get:GET("top-headlines?country=in&category=sports&apiKey=ac4f9dccb02a4335bc7b1e3fda12e7aa")
    val sourceNews: Call<ResonseClass>

    @GET("top-headlines?country=in&apiKey=ac4f9dccb02a4335bc7b1e3fda12e7aa")
    fun getnewsData(): Call<ResonseClass>
}
