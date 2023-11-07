package com.example.restaurant_test.ui.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammer_test.domain.interactor.interactor.category.CategoryInteractor
import com.example.hammer_test.domain.model.bannerModel.BannerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryInteractor: CategoryInteractor
) : ViewModel() {

    private val bannerLiveData_: MutableLiveData<List<BannerModel>> =
        MutableLiveData<List<BannerModel>>()
    val bannerLiveData: LiveData<List<BannerModel>> = bannerLiveData_
    private val subCategoryListLiveData_: MutableLiveData<List<SubCategoryListModel>> =
        MutableLiveData<List<SubCategoryListModel>>()
    val subCategoryListLiveData: LiveData<List<SubCategoryListModel>> = subCategoryListLiveData_


    private val subCategoryItemLiveData_: MutableLiveData<SubCategoryListModel> =
        MutableLiveData<SubCategoryListModel>()
    val subCategoryItemLiveData: LiveData<SubCategoryListModel> = subCategoryItemLiveData_


    private val subMenuItemList: MutableList<SubCategoryListModel> = mutableListOf()

    init {
        getSubCategoryList()
    }

    @SuppressLint("SuspiciousIndentation")
    fun getBannerList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = categoryInteractor.getBannerList()
                bannerLiveData_.postValue(result)
            }
        }
    }

    fun getSubCategoryList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                subMenuItemList.addAll(categoryInteractor.getSubCategoryList())
                subCategoryListLiveData_.postValue(subMenuItemList)
                subMenuItemList.firstOrNull()?.let {
                    subCategoryItemLiveData_.postValue(it)
                }
            }
        }
    }

    fun getSubItemList(keyword: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                subMenuItemList.firstOrNull { it.keyword == keyword }
                    ?.let {
                        subCategoryItemLiveData_.postValue(it)
                    }
            }
        }
    }

}