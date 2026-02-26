package com.abexa.Checky.ui.data.datasource.api

import com.abexa.Checky.ui.data.request.LoginRequest
import com.abexa.Checky.ui.data.response.LoginResponse
import com.abexa.Checky.ui.data.response.UserResponse
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