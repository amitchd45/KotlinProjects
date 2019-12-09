package com.omninos.kotlinexample.retrofit

import com.omninos.kotlinexample.modelClass.ResonseClass
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @get:GET("top-headlines?country=in&apiKey=b4f0614a42bc491498fa9fc73943a173")
    val everthing: Call<ResonseClass>

    @get:GET("top-headlines?country=in&category=sports&apiKey=b4f0614a42bc491498fa9fc73943a173")
    val sourceNews: Call<ResonseClass>

    @GET("top-headlines?country=us&apiKey=b4f0614a42bc491498fa9fc73943a173")
    fun getnewsData(): Call<ResonseClass>
}
