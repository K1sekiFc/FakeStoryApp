package com.abexa.Checky.ui.domain.usecase

import com.abexa.Checky.ui.domain.entity.UserEntity
import com.abexa.Checky.ui.domain.repository.AuthRepository
import javax.inject.Inject

class UsecaseLogin @Inject constructor(private val authRepository: AuthRepository) {
//    suspend operator fun invoke(user: String, password: String): UserEntity?{
//        if(user.contains("@utp.edu.pe")){
//
//            return null
//        }
//        val response :List<UserEntity> = authRepository.doLogin(user,password)
//        return response.random()
suspend operator fun  invoke(user:String,password: String) :UserEntity
{
    return authRepository.doLogin(user,password)
    }
}