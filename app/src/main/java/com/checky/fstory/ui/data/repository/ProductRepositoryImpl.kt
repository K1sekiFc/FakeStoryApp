package com.checky.fstory.ui.data.repository

import android.util.Log
import com.checky.fstory.ui.data.datasource.api.ProductApi
import com.checky.fstory.ui.data.response.toDomain
import com.checky.fstory.ui.domain.entity.ProductEntity
import com.checky.fstory.ui.domain.repository.ProductRepository
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