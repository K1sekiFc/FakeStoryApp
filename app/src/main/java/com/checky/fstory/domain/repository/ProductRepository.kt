package com.checky.fstory.ui.domain.repository

import com.checky.fstory.ui.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getAllProduct (): Flow<List<ProductEntity>>

}