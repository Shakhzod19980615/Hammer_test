package com.example.hammer_test.di.response.mainCategoryResponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainCategoryResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("keyword")
    val keyword : String,
    @SerialName("title")
    val title : String,
    @SerialName("icon_s")
    val image : String,
    @SerialName ("ads_image")
    val ads_image : String,
    @SerialName ("children")
    val itemsOfMainCategory : List<MainCategoryItemsResponse>
)