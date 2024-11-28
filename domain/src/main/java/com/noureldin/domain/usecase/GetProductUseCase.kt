package com.noureldin.domain.usecase

import com.noureldin.domain.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend fun execute(category: Int?) = repository.getProducts(category)
}