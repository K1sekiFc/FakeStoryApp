package com.checky.fstory.ui.data.repository

import com.checky.fstory.ui.data.datasource.api.CartApi
import com.checky.fstory.ui.data.datasource.preferences.SessionDataStore
import com.checky.fstory.ui.data.response.toDomain
import com.checky.fstory.ui.domain.entity.CartEntity
import com.checky.fstory.ui.domain.repository.CartRepository
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