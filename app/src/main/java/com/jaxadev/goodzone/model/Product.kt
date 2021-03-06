package com.jaxadev.goodzone.model

data class Product(
    val active: Boolean,
    val category: Category,
    val id: String,
    val image: String,
    val name: String,
    val order: String,
    val slug: String,
    val brand: Brand,
    val preview_text: String,
    val price: Price
)