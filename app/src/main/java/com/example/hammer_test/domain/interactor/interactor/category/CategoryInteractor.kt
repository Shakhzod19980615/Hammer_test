package com.example.hammer_test.domain.interactor.interactor.category

import com.example.hammer_test.domain.model.mainCategoryModel.MainCategoryModel
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import uz.demo.dana.domain.model.subcategory.SubCategoryItemModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel

interface CategoryInteractor {
    suspend fun getMainCategory() : List<MainCategoryModel>
    suspend fun getSubCategoryList() : List<SubCategoryListModel>

   // suspend fun getSaladList():MenuListModel
}