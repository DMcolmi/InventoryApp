package com.example.inventory.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Item::class), version = 1)
abstract class ItemRoomDatabase: RoomDatabase() {

    abstract fun getItemDao(): ItemDao

    companion object {

        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null



    }

}