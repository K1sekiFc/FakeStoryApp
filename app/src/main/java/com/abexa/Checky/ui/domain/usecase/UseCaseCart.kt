package com.abexa.Checky.ui.domain.usecase

import com.abexa.Checky.ui.domain.entity.CartEntity
import com.abexa.Checky.ui.domain.repository.CartRepository
import javax.inject.Inject

class UseCaseCart @Inject constructor(private val cartRepository: CartRepository) {
    suspend operator fun invoke (): CartEntity{
    return cartRepository.getCartProfile()
    }

}