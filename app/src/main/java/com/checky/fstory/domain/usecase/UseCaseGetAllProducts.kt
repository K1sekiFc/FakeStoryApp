package com.checky.fstory.domain.usecase

import com.checky.fstory.domain.entity.ProductEntity
import com.checky.fstory.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCaseGetAllProducts @Inject constructor(private val productRepository: ProductRepository){
    suspend operator fun invoke() : Flow<List<ProductEntity>>{
        return productRepository.getAllProduct()
}
}