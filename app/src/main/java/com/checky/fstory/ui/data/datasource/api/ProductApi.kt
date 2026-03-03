package com.checky.fstory.ui.data.datasource.api

import com.checky.fstory.ui.data.response.ProductResponse
import retrofit2.http.GET

interface ProductApi
{

    @GET("/products")
    suspend fun  getAllProducts(
    ): List<ProductResponse>

}