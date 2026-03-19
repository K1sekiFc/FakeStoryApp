package com.checky.fstory.data.repository

import android.util.Log
import com.checky.fstory.data.local.dao.ProductDao
import com.checky.fstory.data.remote.api.ProductApi
import com.checky.fstory.data.mapper.toDb
import com.checky.fstory.data.mapper.toDomain
import com.checky.fstory.domain.entity.ProductEntity
import com.checky.fstory.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi,
    private val dao: ProductDao
) : ProductRepository {

    override suspend fun getAllProduct(): Flow<List<ProductEntity>>{
        return dao.getAllProducts()
            .map { list -> list.map{it.toDomain()}}
    }
    override suspend fun refreshProduct(){
        try{
        val remote =api.getAllProducts()
        dao.clearProducts()
        dao.insertProducts(remote.map { it.toDb() })
    }catch (e: Exception) {
         Log.e("Repo", "Error al refrescar productos", e)
        throw e // Re-lanzamos para que el ViewModel sepa que falló
    }
}

//        val localProducts = dao.getAllProducts()
//
//        return try {
//            val remoteProducts = api.getAllProducts()
//
//            dao.clearProducts()
//            dao.insertProducts(remoteProducts.map { it.toDb() })
//
//            remoteProducts.map { it.toDomain() }
//        } catch (e: Exception) {
//            if (localProducts.isNotEmpty()) {
//                localProducts.map { it.toDomain() }
//            } else {
//                throw e
//            }
//        }
//    }
}

//    override suspend fun getAllProduct():  List<ProductEntity> {
//        return try {
//            api.getAllProducts().map { it.toDomain()}
//
//        }catch (e: Exception){
//            Log.i("ERROR : ", "$e")
//            throw e
//
//        }
//    }
