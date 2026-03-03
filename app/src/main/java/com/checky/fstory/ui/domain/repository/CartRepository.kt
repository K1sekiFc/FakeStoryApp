package com.checky.fstory.ui.domain.repository

import com.checky.fstory.ui.domain.entity.CartEntity

interface CartRepository {
    suspend fun getCartProfile(): CartEntity
}