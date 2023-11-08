/*
package com.example.hammer_test.data

import android.animation.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class MyListConverter : TypeConverter<List<MyObject>, String> {
    override fun fromString(value: String): List<MyObject> {
        // Convert JSON string to a list of MyObject objects
        val gson = GsonBuilder().create()
        return gson.fromJson(value, object : TypeToken<List<MyObject>>() {})
    }

    override fun toString(value: List<MyObject>): String {
        // Convert list of MyObject objects to JSON string
        val gson = GsonBuilder().create()
        return gson.toJson(value)
    }
}*/
