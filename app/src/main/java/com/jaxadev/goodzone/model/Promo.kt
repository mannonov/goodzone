package com.jaxadev.goodzone.model

data class Promo(
    val active: Boolean,
    val created_at: String,
    val end_time: String,
    val formatted_date: String,
    val formatted_end_date: String,
    val formatted_start_date: String,
    val id: String,
    val lang: String,
    val preview_image: String,
    val slug: String,
    val start_time: String,
    val title: String,
    val updated_at: String
)