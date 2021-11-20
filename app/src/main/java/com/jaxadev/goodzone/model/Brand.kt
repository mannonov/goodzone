package com.jaxadev.goodzone.model

data class Brand(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val image: String,
    val name: String,
    val order: String,
    val preview_text: String,
    val slug: String,
    val updated_at: String
)