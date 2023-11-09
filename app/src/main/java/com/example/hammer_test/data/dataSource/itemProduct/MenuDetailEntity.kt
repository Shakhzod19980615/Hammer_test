package com.example.hammer_test.data.dataSource.itemProduct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import uz.demo.dana.data.dataSource.itemProduct.MenuEntity


@Entity(
    tableName = "menu_detail_table",
    foreignKeys = [ForeignKey(
        entity = MenuEntity::class,
        parentColumns = ["menuId"],
        childColumns = ["menuId"],
        onDelete = ForeignKey.CASCADE
    )]
)

class MenuDetailEntity (
        @PrimaryKey
        @ColumnInfo(name = "menuDetailId")
        val menuDetailId: Int,
        @ColumnInfo(name = "menuId") // Add the menuId column here
        val menuId: Int,
        @ColumnInfo(name = "menuItemName")
        val menuItemName: String,
        @ColumnInfo(name = "menuItemImage")
        val menuItemImage: String,
        @ColumnInfo(name = "menuItemPrice")
        val menuItemPrice: String,
        @ColumnInfo(name = "menuItemRating")
        val menuItemRating: Double,
        @ColumnInfo(name = "menuItemShopName")
        val menuItemShopName: String,
        @ColumnInfo(name = "menuItemStatus")
        val menuItemStatus: String,
        @ColumnInfo(name = "menuItemKeyword")
        val menuItemKeyword: String,


        )
