package com.abexa.Checky.ui.domain.repository

import com.abexa.Checky.ui.domain.entity.CartEntity

interface CartRepository {
    suspend fun getCartProfile(): CartEntity
}