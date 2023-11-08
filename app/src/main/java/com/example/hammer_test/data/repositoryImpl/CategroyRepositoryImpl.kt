package com.example.restaurant_test.data.repositoryImpl

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.hammer_test.data.ApiService
import com.example.hammer_test.data.bannerDataSource.BannerItemDao
import com.example.hammer_test.data.mapper.mapToBannerEntity
import com.example.hammer_test.data.mapper.mapToBannerModel
import com.example.hammer_test.domain.model.bannerModel.BannerModel
import com.example.hammer_test.domain.repository.CategoryRepository
import com.example.restaurant_test.data.mapper.mapToMainCategoryModel

import com.example.restaurant_test.data.mapper.mapToSubCategoryListModel

import uz.demo.dana.domain.model.subcategory.SubCategoryListModel
import java.util.*
import javax.inject.Inject

class CategroyRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val bannerItemDao: BannerItemDao,
    private val context: Context,
): CategoryRepository {

    @SuppressLint("SuspiciousIndentation")
    override suspend fun getBannerList(): List<BannerModel> {
        return try{
            if(checkForInternet(context = context)){
                val result = apiService.getBannerList()
             /*for(bannerItem in result.map { it.mapToBannerEntity() }){
                 bannerItemDao.insertBannerItem(bannerItemEntity = bannerItem)
             }*/
                bannerItemDao.insertBannerItem(bannerItemEntity =result.map { it.mapToBannerEntity() })
              return result.map { it.mapToMainCategoryModel() } //bannerItemDao.insertBannerItem(bannerItemEntity =result.map { it.mapToBannerEntity() })
            }else{
                val result = bannerItemDao.getBannerList()
                result.map { it.mapToBannerModel() }
            }

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

    private fun checkForInternet(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

}