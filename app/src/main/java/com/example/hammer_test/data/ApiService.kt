package com.example.hammer_test.data


import com.example.hammer_test.di.response.mainCategoryResponse.MainCategoryResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryListResponse
import com.example.restaurant_test.di.response.categoryResponse.CategoryListResponse
import com.example.restaurant_test.di.response.menuResponse.MenuListResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v1/flowers/main-category/list/ru")
    suspend fun getMainCategory(): List<MainCategoryResponse>
    @GET("/api/v1/flowers/category-item/uz")
    suspend fun getSubCategoryList(): List<SubCategoryListResponse>
}