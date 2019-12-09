package com.omninos.kotlinexample.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL = "https://newsapi.org/v2/"
    var retrofit: Retrofit? = null

    fun apiclient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        }
        return retrofit!!
    }
}
