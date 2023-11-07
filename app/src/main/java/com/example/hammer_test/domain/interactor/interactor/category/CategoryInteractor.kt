package com.example.hammer_test.domain.interactor.interactor.category

import com.example.hammer_test.domain.model.bannerModel.BannerModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel

interface CategoryInteractor {
    suspend fun getBannerList() : List<BannerModel>
    suspend fun getSubCategoryList() : List<SubCategoryListModel>

   // suspend fun getSaladList():MenuListModel
}