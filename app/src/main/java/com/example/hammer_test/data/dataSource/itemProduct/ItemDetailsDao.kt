package uz.demo.dana.data.dataSource.itemProduct

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDetailsDao {
    @Query("SELECT * FROM product_detail_table")
    suspend fun getAllItemDetails():List<ItemDetailEntity>
    @Insert
    suspend fun insertAllItemDetails(itemDetails: List<ItemDetailEntity>)
    @Delete
    suspend fun delete(itemDetail: ItemDetailEntity)
}