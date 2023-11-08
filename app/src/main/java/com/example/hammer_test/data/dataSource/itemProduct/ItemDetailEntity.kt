package uz.demo.dana.data.dataSource.itemProduct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_detail_table")
class ItemDetailEntity (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "itemId")
    val itemId: Int,
    @ColumnInfo(name = "itemName")
    val itemName: String,
    @ColumnInfo(name = "itemPrice")
    val itemPrice: String,
    @ColumnInfo(name = "itemImage")
    val itemImage: String,
    @ColumnInfo(name = "shopName")
    val shopName: String,
    @ColumnInfo(name = "rating")
    val rating: String,
    @ColumnInfo(name = "keyword")
    val keyword: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "priceInt")
    val priceInt: Double,
        )