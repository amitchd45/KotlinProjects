package com.omninos.kotlinexample.util


import android.app.Application
import android.content.Context

class App : Application() {

    private var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this
        appPreference = AppPreference.init(context!!)
        sinltonPojo =
            SingltonPojo()
    }

    companion object {
        private val instance: App? = null
        var appPreference: AppPreference? = null
            private set
        var sinltonPojo: SingltonPojo? = null
            private set

        fun getContext(): App? {
            return instance
        }
    }
}

