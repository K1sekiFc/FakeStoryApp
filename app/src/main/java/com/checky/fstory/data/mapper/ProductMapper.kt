package com.checky.fstory.ui.data.mapper

import com.checky.fstory.ui.data.local.entity.ProductDbEntity
import com.checky.fstory.ui.data.remote.model.response.ProductResponse
import com.checky.fstory.ui.domain.entity.ProductEntity



// Remote -> DB
fun ProductResponse.toDb(): ProductDbEntity {
    return ProductDbEntity(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        image = image,
        rating = rating.rate
    )
}

// DB -> Domain
fun ProductDbEntity.toDomain(): ProductEntity {
    return ProductEntity(
        productId = id,
        title = title,
        price = price,
        descriptor = description,
        category = category,
        image = image,
        rating = rating
    )
}