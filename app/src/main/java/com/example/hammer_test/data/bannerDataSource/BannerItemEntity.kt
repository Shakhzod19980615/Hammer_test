package com.example.hammer_test.data.bannerDataSource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity(tableName = "banner_table")
class BannerItemEntity @Inject constructor (
        @PrimaryKey val id: Int,
        @ColumnInfo(name = "bannerId")
        val bannerId: Int,
        @ColumnInfo(name = "keyword")
        val bannerKeyword:String,
        @ColumnInfo(name="image")
        val bannerImage:String,
        @ColumnInfo(name = "title")
        val bannerTitle:String,
        @ColumnInfo(name = "ads_image")
        val bannerAdsImage:String
        )