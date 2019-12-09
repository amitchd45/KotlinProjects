package com.omninos.kotlinexample.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class AppPreference private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences


    init {

        sharedPreferences = context.getSharedPreferences("SomeData", Context.MODE_PRIVATE)
    }

    fun SaveString(key: String, value: String) {

        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.commit()
    }


    fun GetString(key: String): String? {

        return sharedPreferences.getString(key, "")
    }

    fun Logout(activity: Activity) {

        sharedPreferences.edit().clear().apply()
    }

    companion object {

        private var appPreference: AppPreference? = null

        fun init(context: Context): AppPreference {
            if (appPreference == null) {
                appPreference =
                    AppPreference(context)
            }
            return appPreference as AppPreference
        }
    }
}
