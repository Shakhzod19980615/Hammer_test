package com.example.restaurant_test.data.mapper

import com.example.hammer_test.di.response.mainCategoryResponse.BannerResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryItemResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryListResponse
import com.example.hammer_test.domain.model.bannerModel.BannerModel
import uz.demo.dana.domain.model.subcategory.SubCategoryItemModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel


fun BannerResponse.mapToMainCategoryModel(): BannerModel {
    return BannerModel(
        id = id,
        title = title,
        keyword = keyword,
        image = image,
        ads_image = ads_image,
        //itemsOfMainCategory = itemsOfMainCategory
    )
}
fun SubCategoryListResponse.mapToSubCategoryListModel(): SubCategoryListModel {
    return SubCategoryListModel(
        id = id,
        keyword = keyword,
        title = title,
        items = items.map { it.mapToSubCategoryItemModel() }
    )
}
fun SubCategoryItemResponse.mapToSubCategoryItemModel(): SubCategoryItemModel {
    return SubCategoryItemModel(
        id = id,
        name = name,
        image = image,
        price = price,
        rating = rating,
        shopName = shopName,
        status = status,
        keyword = keyword,

        )
}