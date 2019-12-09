package com.omninos.kotlinexample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.omninos.kotlinexample.R
import com.omninos.kotlinexample.modelClass.ResonseClass
import com.omninos.kotlinexample.retrofit.Api
import com.omninos.kotlinexample.retrofit.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CorotiensDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corotiens_demo)

        val api = ApiClient.apiclient().create(Api::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            api.getnewsData().enqueue(object : Callback<ResonseClass> {
                override fun onFailure(call: Call<ResonseClass>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResonseClass>,
                    response: Response<ResonseClass>
                ) {
                    if (response.isSuccessful) {
                        println("Data" + response.body()?.articles!!.size)
                    }
                }

            })
        }
    }
}
