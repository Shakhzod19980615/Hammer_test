package uz.demo.dana.di.room

import android.app.Application
import androidx.room.Room
import com.example.hammer_test.data.AppDatabase
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(applicationContext: Application): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideBannerDao(db:AppDatabase) = db.bannerItemDao
   /* @Singleton
    @Provides
    fun provideMenuDao(db:AppDatabase) = db.menuDao*/
}