package com.abexa.Checky.ui.data.response

import com.abexa.Checky.ui.domain.entity.ProductEntity
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

fun ProductResponse.toDomain() : ProductEntity{
    return ProductEntity(
        productId= id ,
        title =title,
        price = price,
        descriptor= description,
        category= category ,
        image =image,
        rating = rating.rate
    )
}