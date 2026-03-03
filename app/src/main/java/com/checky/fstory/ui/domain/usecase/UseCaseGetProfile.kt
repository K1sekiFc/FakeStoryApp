package com.checky.fstory.ui.domain.usecase

import com.checky.fstory.ui.domain.entity.UserEntity
import com.checky.fstory.ui.domain.repository.AuthRepository
import javax.inject.Inject

class UseCaseGetProfile @Inject constructor(private val authRepository: AuthRepository){
    suspend operator fun invoke(): UserEntity{
        return authRepository.getUserProfile()
    }
}