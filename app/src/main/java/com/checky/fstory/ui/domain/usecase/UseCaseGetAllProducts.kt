package com.checky.fstory.ui.domain.usecase

import com.checky.fstory.ui.domain.entity.ProductEntity
import com.checky.fstory.ui.domain.repository.ProductRepository
import javax.inject.Inject

class UseCaseGetAllProducts @Inject constructor(private val productRepository: ProductRepository){
    suspend operator fun invoke() : List<ProductEntity>{
        return productRepository.getAllProduct()
}
}