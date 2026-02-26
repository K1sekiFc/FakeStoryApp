package com.abexa.Checky.ui.domain.usecase

import com.abexa.Checky.ui.domain.entity.ProductEntity
import com.abexa.Checky.ui.domain.repository.ProductRepository
import javax.inject.Inject

class UseCaseGetAllProducts @Inject constructor(private val productRepository: ProductRepository){
    suspend operator fun invoke() : List<ProductEntity>{
        return productRepository.getAllProduct()
}
}