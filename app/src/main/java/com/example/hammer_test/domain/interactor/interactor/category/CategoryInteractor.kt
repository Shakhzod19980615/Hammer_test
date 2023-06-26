package com.example.hammer_test.domain.interactor.interactor.category

import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel

interface CategoryInteractor {
    suspend fun getCategoryList(): CategoryListModel
    suspend fun getMenuList(): MenuListModel
   // suspend fun getSaladList():MenuListModel
}