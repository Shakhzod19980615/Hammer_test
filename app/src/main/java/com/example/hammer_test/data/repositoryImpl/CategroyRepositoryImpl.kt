package com.example.restaurant_test.data.repositoryImpl

import android.annotation.SuppressLint
import com.example.hammer_test.data.ApiService
import com.example.hammer_test.domain.model.mainCategoryModel.MainCategoryModel
import com.example.hammer_test.domain.repository.CategoryRepository
import com.example.restaurant_test.data.mapper.mapToCategoryListModel
import com.example.restaurant_test.data.mapper.mapToMainCategoryModel
import com.example.restaurant_test.data.mapper.mapToMenuListModel
import com.example.restaurant_test.data.mapper.mapToSubCategoryListModel
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel
import java.util.*
import javax.inject.Inject

class CategroyRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
): CategoryRepository {

    @SuppressLint("SuspiciousIndentation")
    override suspend fun getMainCategory(): List<MainCategoryModel> {
        return try{
            val result = apiService.getMainCategory()
            result.map { it.mapToMainCategoryModel() }
        }catch (e : Exception){
            return Collections.emptyList()
        }
    }
    override suspend fun getSubCategoryList(): List<SubCategoryListModel> {
        return try{
            val result = apiService.getSubCategoryList()
            result.map { it.mapToSubCategoryListModel() }

        }catch (e:Exception) {
            return Collections.emptyList()
        }
    }
}