package com.example.hammer_test.data.mapper

import com.example.hammer_test.data.bannerDataSource.BannerItemEntity
import com.example.hammer_test.data.dataSource.itemProduct.MenuDetailEntity
import com.example.hammer_test.di.response.mainCategoryResponse.BannerResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryItemResponse
import com.example.hammer_test.di.response.menuResponse.SubCategoryListResponse
import com.example.hammer_test.domain.model.bannerModel.BannerModel
import uz.demo.dana.data.dataSource.itemProduct.MenuEntity
import uz.demo.dana.domain.model.subcategory.SubCategoryItemModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel

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

fun SubCategoryListResponse.mapToMenuListEntity():MenuEntity{
    return MenuEntity(
        menuId = id,
        menuTitle =  title,
        menuKeyword = keyword,
        //menuItemDetail = items.map { it.mapToMenuItemDetailEntity() }
    )
}
fun SubCategoryItemResponse.mapToMenuItemDetailEntity():MenuDetailEntity{
    return MenuDetailEntity(
        menuDetailId = id,
        menuItemName = name,
        menuItemImage = image,
        menuItemKeyword = keyword,
        menuItemPrice = price,
        menuItemRating = rating,
        menuItemShopName = shopName,
        menuItemStatus = status
    )
}
/*fun MenuEntity.mapFromMenuEntityToMenuModel():SubCategoryListModel{
    return SubCategoryListModel(
        id = menuId,
        title = menuTitle,
        keyword = menuKeyword,
       // items = menuItemDetail.map { it.mapFromMenuDetailEntityToMenuItemModel() }
    )
}*/
fun MenuDetailEntity.mapFromMenuDetailEntityToMenuItemModel():SubCategoryItemModel{
   return SubCategoryItemModel(
       id = menuDetailId,
       name = menuItemName,
       keyword = menuItemKeyword,
       image = menuItemImage,
       price = menuItemPrice,
       rating = menuItemRating,
       shopName = menuItemShopName,
       status = menuItemStatus
   )
}