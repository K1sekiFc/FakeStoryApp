package com.checky.fstory.domain.entity

data class CartEntity(
    val id: Int,
    val userId: Int,
    val date : String,
    val productsCart: List<ProductCartEntity>
)

data class ProductCartEntity(
    val productId: Int,
    val quantity: Int
)


