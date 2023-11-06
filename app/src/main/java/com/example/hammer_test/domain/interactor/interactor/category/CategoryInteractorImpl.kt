package com.example.hammer_test.domain.interactor.interactor.category

import com.example.hammer_test.domain.model.mainCategoryModel.MainCategoryModel
import com.example.hammer_test.domain.repository.CategoryRepository
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel

import javax.inject.Inject

class CategoryInteractorImpl @Inject constructor(
        private val categoryRepository: CategoryRepository
): CategoryInteractor {
    override suspend fun getMainCategory(): List<MainCategoryModel> {
        return categoryRepository.getMainCategory()
    }
    override suspend fun getSubCategoryList(): List<SubCategoryListModel> {
        return  categoryRepository.getSubCategoryList()
    }
}