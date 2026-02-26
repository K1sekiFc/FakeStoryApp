package com.abexa.Checky.ui.data.datasource.api

import com.abexa.Checky.ui.data.response.CartResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CartApi {

    @GET("/cart/{id}")
    suspend fun  getCartByUser(
        @Path("id") userid: String?
    ): CartResponse

}
