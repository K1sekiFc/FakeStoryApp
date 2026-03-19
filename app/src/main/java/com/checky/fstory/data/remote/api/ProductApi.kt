package com.checky.fstory.data.remote.api

import com.checky.fstory.data.remote.model.response.ProductResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ProductApi
{

    @GET("/products")
   suspend fun  getAllProducts(
    ): List<ProductResponse>

}