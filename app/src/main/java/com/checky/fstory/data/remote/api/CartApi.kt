package com.checky.fstory.ui.data.remote.api

import com.checky.fstory.ui.data.remote.model.response.CartResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CartApi {

    @GET("/cart/{id}")
    suspend fun  getCartByUser(
        @Path("id") userid: String?
    ): CartResponse

}
