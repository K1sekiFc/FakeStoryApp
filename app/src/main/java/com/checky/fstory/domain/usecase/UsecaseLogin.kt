package com.checky.fstory.domain.usecase

import com.checky.fstory.domain.entity.UserEntity
import com.checky.fstory.domain.repository.AuthRepository
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