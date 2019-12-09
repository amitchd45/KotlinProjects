package com.omninos.kotlinexample.myViewModel

import android.app.Activity
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omninos.kotlinexample.modelClass.ResonseClass
import com.omninos.kotlinexample.retrofit.Api
import com.omninos.kotlinexample.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetNewsViewModel : ViewModel() {

    private var sendOTPMutableLiveData: MutableLiveData<ResonseClass>? = null

    fun checkphonenumber(activity: Activity): LiveData<ResonseClass> {
        sendOTPMutableLiveData = MutableLiveData<ResonseClass>()

        val api= ApiClient.apiclient().create(Api::class.java)
        api.getnewsData().enqueue(object :Callback<ResonseClass>{
            override fun onFailure(call: Call<ResonseClass>, t: Throwable) {

            }
            override fun onResponse(call: Call<ResonseClass>, response: Response<ResonseClass>) {
                if (response.isSuccessful){
                    println("Data"+ response.body()?.articles!!.size)
                    sendOTPMutableLiveData!!.value=response.body()

//                    val sendOTPModel = ResonseClass()
//                    sendOTPModel.status="OK"
//                    sendOTPMutableLiveData!!.value=sendOTPModel
                }
            }

        })

        return sendOTPMutableLiveData as MutableLiveData<ResonseClass>
    }
}
