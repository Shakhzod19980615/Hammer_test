package com.example.restaurant_test.ui.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammer_test.domain.interactor.interactor.category.CategoryInteractor
import com.example.hammer_test.domain.model.mainCategoryModel.MainCategoryModel
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.demo.dana.domain.model.subcategory.SubCategoryItemModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryInteractor: CategoryInteractor
): ViewModel() {

    private val mainCategoryLiveData_ : MutableLiveData<List<MainCategoryModel>>
            = MutableLiveData<List<MainCategoryModel>>()
    val mainCategoryLiveData : LiveData<List<MainCategoryModel>> = mainCategoryLiveData_
    private val subCategoryListLiveData_: MutableLiveData<List<SubCategoryListModel>>
            = MutableLiveData<List<SubCategoryListModel>>()
    val subCategoryListLiveData : LiveData<List<SubCategoryListModel>> = subCategoryListLiveData_
    private val subCategoryItemLiveData_ :MutableLiveData<List<SubCategoryItemModel>>
            = MutableLiveData<List<SubCategoryItemModel>>()
    val subCategoryItemLiveData : LiveData<List<SubCategoryItemModel>> = subCategoryItemLiveData_


    @SuppressLint("SuspiciousIndentation")
    fun getMainCategory(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = categoryInteractor.getMainCategory()
                mainCategoryLiveData_.postValue(result)
            }
        }
    }
    fun getSubCategoryList(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = categoryInteractor.getSubCategoryList()
                subCategoryListLiveData_.postValue(result)
            }
        }
    }

}