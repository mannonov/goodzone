package com.jaxadev.goodzone.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jaxadev.goodzone.databinding.ItemProductBinding
import com.jaxadev.goodzone.model.Product

class ProductRecyclerViewAdapter(val products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = products[position]

        holder.binding.apply {

            tvProductCatrgory.text = product.category.name
            tvProductName.text = product.name
            tvProductPrice.text = product.price.price
            Glide.with(imgProduct.context).asBitmap().load(product.image)
                .into(imgProduct)

        }
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

}