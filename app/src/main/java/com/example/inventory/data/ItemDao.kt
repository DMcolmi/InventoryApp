package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("select * from item where id = :idItem")
    fun getItemById(idItem: Int): Flow<Item>

    @Query("select * from item order by name asc")
    fun getAllItems(): Flow<List<Item>>

}