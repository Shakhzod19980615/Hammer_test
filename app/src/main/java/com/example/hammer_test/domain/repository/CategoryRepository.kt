package com.example.hammer_test.domain.repository

import com.example.hammer_test.domain.model.bannerModel.BannerModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel


interface CategoryRepository {
       suspend fun getBannerList() : List<BannerModel>
       suspend fun getSubCategoryList(): List<SubCategoryListModel>
    //suspend fun getSaladList():List<MenuListModel>
}