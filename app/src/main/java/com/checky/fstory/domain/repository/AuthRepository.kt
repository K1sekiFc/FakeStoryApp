package com.checky.fstory.domain.repository



import com.checky.fstory.domain.entity.UserEntity

interface AuthRepository {
//    suspend fun doLogin(user: String, password: String): List<UserEntity>
    suspend fun doLogin(user: String, password: String): UserEntity
    suspend fun getUserProfile(): UserEntity

}