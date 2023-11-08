package com.example.hammer_test.di

import android.app.Application
import android.content.Context
import com.example.hammer_test.app.DemoApplication
import com.example.hammer_test.di.networkmodule.ContextModule
import com.example.hammer_test.ui.fragments.*
import com.example.restaurant_test.di.networkmodule.NetworkModule
import com.example.restaurant_test.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import uz.demo.dana.di.room.DatabaseModule
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, ContextModule::class, NetworkModule::class,ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: MenuFragment)
    fun inject(fragment: CartFragment)
    fun inject(fragment: ProfileFragment)
    fun inject (context: Context)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    companion object {
        private var instance: AppComponent? = null
        lateinit var application: Application

        fun create(application: Application):AppComponent{
            instance = DaggerAppComponent.factory().create(application)
            return instance!!
        }

        fun get(): AppComponent {
            return requireNotNull(instance) {"AppComponent  must be initialized"}
        }



    }

}