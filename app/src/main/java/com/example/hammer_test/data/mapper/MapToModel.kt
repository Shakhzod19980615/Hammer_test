package com.example.restaurant_test.data.mapper

import com.example.hammer_test.di.response.mainCategoryResponse.MainCategoryResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryItemResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryListResponse
import com.example.hammer_test.domain.model.mainCategoryModel.MainCategoryModel
import com.example.restaurant_test.di.response.categoryResponse.CategoryItemResponse
import com.example.restaurant_test.di.response.categoryResponse.CategoryListResponse
import com.example.restaurant_test.di.response.menuResponse.MenuItemResponse
import com.example.restaurant_test.di.response.menuResponse.MenuListResponse
import com.example.restaurant_test.domain.model.categoryModel.CategoryItemModel
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import uz.demo.dana.domain.model.subcategory.SubCategoryItemModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel

fun CategoryListResponse.mapToCategoryListModel(): CategoryListModel {
    return  CategoryListModel(
        categories = categories.map { it.mapToCategoryItemModel() }
    )
}
fun CategoryItemResponse.mapToCategoryItemModel(): CategoryItemModel {
    return  CategoryItemModel(
        id = id,
        name = name,
        image = image
    )
}

fun MenuListResponse.mapToMenuListModel(): MenuListModel{
    return MenuListModel(
        menus = dishes.map { it.mapToMenuItemModel() }
    )
}

fun MenuItemResponse.mapToMenuItemModel(): MenuItemModel {
    return  MenuItemModel(
        id = id,
        dishName = dishName,
        price = price,
        weight = weight,
        description =description,
        dishImage=dishImage,
        tegs = tegs,
        itemCount = 1
    )
}

fun MainCategoryResponse.mapToMainCategoryModel(): MainCategoryModel {
    return MainCategoryModel(
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