package com.abexa.Checky.ui.data.datasource.api

import com.abexa.Checky.ui.data.response.ProductResponse
import retrofit2.http.GET

interface ProductApi
{

    @GET("/products")
    suspend fun  getAllProducts(
    ): List<ProductResponse>

}