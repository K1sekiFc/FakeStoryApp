package com.abexa.Checky.ui.domain.repository

import com.abexa.Checky.ui.domain.entity.ProductEntity

interface ProductRepository {
    suspend fun getAllProduct ():List <ProductEntity>

}