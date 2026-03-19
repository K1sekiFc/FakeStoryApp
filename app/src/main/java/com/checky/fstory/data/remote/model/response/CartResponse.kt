package com.checky.fstory.data.remote.model.response

import com.checky.fstory.domain.entity.CartEntity
import com.checky.fstory.domain.entity.ProductCartEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CartResponse(
    val id: Int,
    val userId: Int,
    val date :String,
    val productsCart: List<ProductCart>,


    @SerialName("__v")
    val version: Int
)

@Serializable
data class ProductCart(
    val productId: Int,
    val quantity: Int
)

fun CartResponse.toDomain() = CartEntity(
    id = id,
    userId = userId,
    date = date ,
    productsCart = productsCart.map { it.toDomain() }
)

fun ProductCart.toDomain() = ProductCartEntity(
    productId = productId,
    quantity = quantity
)

