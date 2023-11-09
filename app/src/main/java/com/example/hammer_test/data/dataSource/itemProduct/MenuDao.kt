package uz.demo.dana.data.dataSource.itemProduct

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu_table")
    suspend fun getAllItemDetails():List<MenuEntity>
    @Insert
    suspend fun insertAllItemDetails(itemDetails: List<MenuEntity>)
    @Delete
    suspend fun delete(itemDetail: MenuEntity)
}