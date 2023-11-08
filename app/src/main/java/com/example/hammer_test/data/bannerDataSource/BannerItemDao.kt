package com.example.hammer_test.data.bannerDataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BannerItemDao {
    @Query("SELECT * FROM banner_table")
    suspend fun getBannerList():List<BannerItemEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBannerItem(bannerItemEntity: List<BannerItemEntity>)
}