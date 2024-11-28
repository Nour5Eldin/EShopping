package com.noureldin.domain.usecase

import com.noureldin.domain.repository.CartRepository

class CartSummaryUseCase (private val repository: CartRepository) {
    suspend fun execute(userId: Int) = repository.getCartSummary(userId)
}