package com.checky.fstory.data.remote.model.response

import com.checky.fstory.domain.entity.ProductEntity
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse (
    val id : Int,
    val title : String,
    val price : Float,
    val description : String,
    val category: String,
    val image: String,
    val rating: Rating

)


@Serializable
data class Rating(
    val rate : Double,
    val count : Int
)

