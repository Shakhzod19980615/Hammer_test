package com.example.hammer_test.data


import com.example.hammer_test.di.response.mainCategoryResponse.BannerResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryListResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v1/flowers/main-category/list/ru")
    suspend fun getBannerList(): List<BannerResponse>
    @GET("/api/v1/flowers/category-item/uz")
    suspend fun getSubCategoryList(): List<SubCategoryListResponse>
}