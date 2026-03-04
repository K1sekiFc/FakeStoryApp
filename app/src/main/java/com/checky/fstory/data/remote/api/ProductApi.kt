package com.checky.fstory.ui.data.remote.api

import com.checky.fstory.ui.data.remote.model.response.ProductResponse
import retrofit2.http.GET

interface ProductApi
{

    @GET("/products")
    suspend fun  getAllProducts(
    ): List<ProductResponse>

}