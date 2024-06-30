package com.example.zaraestore

import android.app.Application
import android.content.Context

class ZaraEstoreApp: Application() {
    companion object {
        lateinit var appContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}