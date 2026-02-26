package com.abexa.Checky.ui.domain.usecase

import com.abexa.Checky.ui.domain.entity.UserEntity
import com.abexa.Checky.ui.domain.repository.AuthRepository
import javax.inject.Inject

class UseCaseGetProfile @Inject constructor(private val authRepository: AuthRepository){
    suspend operator fun invoke(): UserEntity{
        return authRepository.getUserProfile()
    }
}