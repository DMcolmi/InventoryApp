package com.example.inventory

import androidx.lifecycle.*
import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel(){

    val allItems: LiveData<List<Item>> = itemDao.getAllItems().asLiveData()


    fun addNewItem(itemName: String, itemPrice: String, quantityInStock: String){
        val item = getNewItemEntry(itemName, itemPrice, quantityInStock)
        insertItem(item)
    }

    private fun insertItem(item: Item){
        viewModelScope.launch {
            itemDao.insertItem(item)
        }
    }

    fun getItemById(id: Int): LiveData<Item> = itemDao.getItemById(id).asLiveData()


    private fun getNewItemEntry(itemName: String, itemPrice: String, quantityInStock: String): Item {
        return Item(
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = quantityInStock.toInt()
        )
    }

    fun isEntryValid(itemName: String, itemPrice: String, quantityInStock: String): Boolean {
        return !(itemName.isBlank() || itemPrice.isBlank() || quantityInStock.isBlank())
    }
}

class InventoryViewModelFactory(private val itemDao: ItemDao): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(InventoryViewModel::class.java)){
            return InventoryViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}