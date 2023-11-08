package com.example.hammer_test.data.mapper

import com.example.hammer_test.data.bannerDataSource.BannerItemEntity
import com.example.hammer_test.di.response.mainCategoryResponse.BannerResponse
import com.example.hammer_test.domain.model.bannerModel.BannerModel

fun BannerModel.mapToBannerItemEntity():BannerItemEntity{
    return BannerItemEntity(
        id = id,
        bannerId = id,
        bannerKeyword = keyword,
        bannerTitle = title,
        bannerImage = image,
        bannerAdsImage = ads_image
    )
}

fun BannerItemEntity.mapToBannerModel():BannerModel{
    return BannerModel(
        id = id,
        title = bannerTitle,
        image = bannerImage,
        keyword = bannerKeyword,
        ads_image = bannerAdsImage
    )
}
fun BannerResponse.mapToBannerEntity():BannerItemEntity{
    return BannerItemEntity(
        id=id,
        bannerId = id,
        bannerKeyword = keyword,
        bannerTitle = title,
        bannerImage = image,
        bannerAdsImage = ads_image
    )
}