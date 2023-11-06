package com.example.hammer_test.domain.repository

import com.example.hammer_test.domain.model.mainCategoryModel.MainCategoryModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel


interface CategoryRepository {
       suspend fun getMainCategory() : List<MainCategoryModel>
       suspend fun getSubCategoryList(): List<SubCategoryListModel>
    //suspend fun getSaladList():List<MenuListModel>
}