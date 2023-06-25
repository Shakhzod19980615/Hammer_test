package com.example.hammer_test.app

import android.app.Application
import com.example.hammer_test.di.AppComponent

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.create(this)
    }
}