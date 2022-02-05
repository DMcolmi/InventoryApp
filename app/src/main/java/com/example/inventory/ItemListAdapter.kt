package com.example.inventory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.data.Item
import com.example.inventory.data.getFormattedPrice
import com.example.inventory.databinding.ItemListItemBinding

class ItemListAdapter(private val onItemClicked: (Item) -> Unit): ListAdapter<Item,ItemListAdapter.ItemViewHolder>(DiffCallback) {

    class ItemViewHolder(private var binding: ItemListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item){
            binding.itemName.text = item.itemName
            binding.itemPrice.text = item.getFormattedPrice()
            binding.itemQuantity.text = item.quantityInStock.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemListAdapter.ItemViewHolder {
        val itemViewHolder = ItemViewHolder(
            ItemListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        itemViewHolder.itemView.setOnClickListener {
            val position = itemViewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return itemViewHolder
    }

    override fun onBindViewHolder(holder: ItemListAdapter.ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

        }
    }

}