package com.jaxadev.goodzone.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jaxadev.goodzone.databinding.HorizontalItemBinding
import com.jaxadev.goodzone.model.DiscountItem

class DiscountRecyclerView(val itemDiscountCallBack: ItemDiscountCallBack) :
    ListAdapter<DiscountItem, DiscountRecyclerView.ViewHolder>(DiscountComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = HorizontalItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(item)

    }


    inner class ViewHolder(private val binding: HorizontalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DiscountItem) {

            Glide.with(binding.imgItemImage.context).asBitmap()
                .load(item.image).into(binding.imgItemImage)

            binding.tvItemText.text = item.text

        }

    }

    class DiscountComparator : DiffUtil.ItemCallback<DiscountItem>() {

        override fun areItemsTheSame(oldItem: DiscountItem, newItem: DiscountItem): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: DiscountItem, newItem: DiscountItem): Boolean {
            return oldItem == newItem
        }
    }

    class ItemDiscountCallBack(val callBack: (discountItem: DiscountItem) -> Unit) {
        fun onDiscountClick(discountItem: DiscountItem) = callBack(discountItem)
    }

}