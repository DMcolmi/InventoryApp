package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "item")
data class Item(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name") @NotNull
    val itemName: String,

    @ColumnInfo(name = "price") @NotNull
    val itemPrice: Double,

    @ColumnInfo(name = "quantity") @NotNull
    val quantityInStock: Int
)
