package com.uae.myvaultspay

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {


    companion object {
        var application: Application? = null
            private set
        val applicationContext: Context
            get() = application!!.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        System.loadLibrary("native-libA")
        System.loadLibrary("native-libB")
    }
}