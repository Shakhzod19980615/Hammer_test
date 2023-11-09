package uz.demo.dana.data.dataSource.itemProduct

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hammer_test.data.dataSource.itemProduct.MenuDetailEntity

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu_table")
    suspend fun getAllItemDetails():List<MenuEntity>
    @Insert
    suspend fun insertAllItemDetails(itemDetails: List<MenuEntity>)
    @Delete
    suspend fun delete(itemDetail: MenuEntity)
    @Query("SELECT * FROM menu_detail_table WHERE menuId = :menuId")
    suspend fun getMenuDetailsByMenuId(menuId:Int):List<MenuDetailEntity>
    @Insert
    suspend fun insertAllMenuDetails(menuDetails: List<MenuDetailEntity>)
}