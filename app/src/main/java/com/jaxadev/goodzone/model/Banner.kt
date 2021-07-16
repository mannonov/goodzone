package com.jaxadev.goodzone.model

data class Banner(

    val id: String,

    val title: String,

    val position: Position,

    val active: Boolean,

    val image: String,

    val url: String,

    val description: String,

    val created_at: String,

    val updated_at: String

)