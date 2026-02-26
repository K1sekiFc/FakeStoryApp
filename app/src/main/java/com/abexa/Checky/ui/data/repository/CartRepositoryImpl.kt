package com.abexa.Checky.ui.data.repository

import com.abexa.Checky.ui.data.datasource.api.CartApi
import com.abexa.Checky.ui.data.datasource.preferences.SessionDataStore
import com.abexa.Checky.ui.data.response.toDomain
import com.abexa.Checky.ui.domain.entity.CartEntity
import com.abexa.Checky.ui.domain.repository.CartRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(private val api: CartApi, private val session: SessionDataStore) : CartRepository{
    override suspend fun getCartProfile(): CartEntity {
        val userId = session.getUserId.first()
        val response = api.getCartByUser(userId)
        val cart = response
        return cart.toDomain()

    }
}