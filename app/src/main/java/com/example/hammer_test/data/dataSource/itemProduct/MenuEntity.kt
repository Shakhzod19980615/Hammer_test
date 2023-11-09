package uz.demo.dana.data.dataSource.itemProduct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hammer_test.data.dataSource.itemProduct.MenuDetailEntity


@Entity(tableName = "menu_table")
class MenuEntity (
    @PrimaryKey
    @ColumnInfo(name = "menuId")
    val menuId: Int,
    @ColumnInfo(name = "menuKeyword")
    val menuKeyword: String,
    @ColumnInfo(name = "menuTitle")
    val menuTitle: String,
  /*  @ColumnInfo(name = "menuItemDetail")
    val menuItemDetail : List<MenuDetailEntity>*/

    )

