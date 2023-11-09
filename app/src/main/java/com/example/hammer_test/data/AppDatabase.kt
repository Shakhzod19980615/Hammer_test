package com.example.hammer_test.data
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hammer_test.data.bannerDataSource.BannerItemDao
import com.example.hammer_test.data.bannerDataSource.BannerItemEntity
import com.example.hammer_test.data.dataSource.itemProduct.MenuDetailEntity
import uz.demo.dana.data.dataSource.itemProduct.MenuDao
import uz.demo.dana.data.dataSource.itemProduct.MenuEntity


@Database(entities = [BannerItemEntity::class, MenuEntity::class, MenuDetailEntity::class],version = 2, exportSchema = true)

abstract class AppDatabase : RoomDatabase() {
    abstract val bannerItemDao: BannerItemDao
    abstract  val menuDao:MenuDao
}