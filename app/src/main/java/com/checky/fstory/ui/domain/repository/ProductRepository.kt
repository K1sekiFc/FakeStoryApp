package com.checky.fstory.ui.domain.repository

import com.checky.fstory.ui.domain.entity.ProductEntity

interface ProductRepository {
    suspend fun getAllProduct ():List <ProductEntity>

}