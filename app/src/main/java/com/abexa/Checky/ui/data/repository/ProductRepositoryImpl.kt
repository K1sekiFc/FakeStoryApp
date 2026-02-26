package com.abexa.Checky.ui.data.repository

import android.util.Log
import com.abexa.Checky.ui.data.datasource.api.ProductApi
import com.abexa.Checky.ui.data.response.toDomain
import com.abexa.Checky.ui.domain.entity.ProductEntity
import com.abexa.Checky.ui.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(val api: ProductApi): ProductRepository {
    override suspend fun getAllProduct():  List<ProductEntity> {


        return try {
            api.getAllProducts().map { it.toDomain()}

        }catch (e: Exception){
            Log.i("ERROR : ", "$e")
            throw e

        }
    }
}