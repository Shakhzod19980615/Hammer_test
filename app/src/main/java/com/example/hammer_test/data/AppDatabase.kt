package com.example.hammer_test.data
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hammer_test.data.bannerDataSource.BannerItemDao
import com.example.hammer_test.data.bannerDataSource.BannerItemEntity


@Database(entities = [BannerItemEntity::class],version = 2, exportSchema = true)

abstract class AppDatabase : RoomDatabase() {
    abstract val bannerItemDao: BannerItemDao
}