package com.checky.fstory.data.remote.api

import com.checky.fstory.data.remote.model.request.LoginRequest
import com.checky.fstory.data.remote.model.response.LoginResponse
import com.checky.fstory.data.remote.model.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {
//    @GET("forLogin/.json")
//    suspend fun doLogin (): List<UserResponse>

    @POST("auth/login/")
    suspend fun doLogin(
        @Body request: LoginRequest
    ): LoginResponse

    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") userId: String
    ): UserResponse

}