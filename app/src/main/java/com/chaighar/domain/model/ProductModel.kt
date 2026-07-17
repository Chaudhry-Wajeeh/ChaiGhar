package com.chaighar.domain.model

data class ProductModel(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageRes: Int,
    val quantity: Int = 1
)