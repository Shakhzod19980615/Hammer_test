package com.example.hammer_test.di.response.menuResponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubCategoryItemResponse(
    @SerialName("id")
    val id : Int,
    @SerialName("name")
    val name : String,
    @SerialName ("image")
    val image : String,
    @SerialName("price")
    val price : String,
    @SerialName("rating")
    val rating: Double,
    @SerialName("shopName")
    val shopName: String,
    @SerialName("statusName")
    val status : String,
    @SerialName("keyword")
    val keyword : String
    )