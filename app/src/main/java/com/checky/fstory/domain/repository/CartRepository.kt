package com.checky.fstory.domain.repository

import com.checky.fstory.domain.entity.CartEntity

interface CartRepository {
    suspend fun getCartProfile(): CartEntity
}