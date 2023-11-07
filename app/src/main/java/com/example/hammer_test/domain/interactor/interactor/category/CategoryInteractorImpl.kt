package com.example.hammer_test.domain.interactor.interactor.category

import com.example.hammer_test.domain.model.bannerModel.BannerModel
import com.example.hammer_test.domain.repository.CategoryRepository
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel

import javax.inject.Inject

class CategoryInteractorImpl @Inject constructor(
        private val categoryRepository: CategoryRepository
): CategoryInteractor {
    override suspend fun getBannerList(): List<BannerModel> {
        return categoryRepository.getBannerList()
    }
    override suspend fun getSubCategoryList(): List<SubCategoryListModel> {
        return  categoryRepository.getSubCategoryList()
    }
}