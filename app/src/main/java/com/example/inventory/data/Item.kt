package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.text.NumberFormat

@Entity(tableName = "item")
data class Item(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name") @NotNull
    val itemName: String,

    @ColumnInfo(name = "price") @NotNull
    val itemPrice: Double,

    @ColumnInfo(name = "quantity") @NotNull
    val quantityInStock: Int
)

fun Item.getFormattedPrice(): String{
    return NumberFormat.getCurrencyInstance().format(itemPrice)
}
