package com.jaxadev.goodzone.model

data class Category(
    val id: String,
    val name: String,
    val parent: Parent,
    val slug: String,
    val active: Boolean,
    val order: String,
    val image: String
)