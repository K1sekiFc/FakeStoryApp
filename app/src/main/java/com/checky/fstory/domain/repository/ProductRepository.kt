package com.checky.fstory.domain.repository

import com.checky.fstory.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getAllProduct (): Flow<List<ProductEntity>>
    suspend fun refreshProduct()
}