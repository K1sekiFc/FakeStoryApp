package com.checky.fstory.domain.usecase

import com.checky.fstory.domain.entity.CartEntity
import com.checky.fstory.domain.repository.CartRepository
import javax.inject.Inject

class UseCaseCart @Inject constructor(private val cartRepository: CartRepository) {
    suspend operator fun invoke (): CartEntity{
    return cartRepository.getCartProfile()
    }

}