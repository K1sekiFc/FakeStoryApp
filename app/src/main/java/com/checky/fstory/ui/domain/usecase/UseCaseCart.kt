package com.checky.fstory.ui.domain.usecase

import com.checky.fstory.ui.domain.entity.CartEntity
import com.checky.fstory.ui.domain.repository.CartRepository
import javax.inject.Inject

class UseCaseCart @Inject constructor(private val cartRepository: CartRepository) {
    suspend operator fun invoke (): CartEntity{
    return cartRepository.getCartProfile()
    }

}