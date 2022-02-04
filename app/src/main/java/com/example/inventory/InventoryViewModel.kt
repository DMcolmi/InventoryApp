package com.example.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.inventory.data.ItemDao
import java.lang.IllegalArgumentException

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel(){



}

class InventoryViewModelFactory(private val itemDao: ItemDao): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(InventoryViewModel::class.java)){
            return InventoryViewModelFactory(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}