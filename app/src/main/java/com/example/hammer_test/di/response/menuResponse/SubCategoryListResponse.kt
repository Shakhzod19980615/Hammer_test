package com.example.hammer_test.di.response.menuResponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubCategoryListResponse (
    @SerialName("id")
    val id: Int,
    @SerialName("keyword")
    val keyword : String,
    @SerialName("title")
    val title : String,
    @SerialName("flowers")
    val items : List<SubCategoryItemResponse>
    )