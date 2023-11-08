package com.example.hammer_test.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.hammer_test.di.AppComponent

class DemoApplication : Application() {

    private var instance: DemoApplication? = null
   /* @SuppressLint("NotConstructor")
    fun DemoApplication() {
        instance = this
    }
*/

    override fun onCreate() {
        super.onCreate()
        if (instance == null) {
            instance = this
        }
        AppComponent.create(this)

    }
    fun getContext(): Context {
        return instance!!
    }

}