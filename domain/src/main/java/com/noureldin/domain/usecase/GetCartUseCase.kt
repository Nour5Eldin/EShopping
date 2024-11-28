package com.noureldin.domain.usecase

import com.noureldin.domain.repository.CartRepository

class GetCartUseCase(val cartRepository: CartRepository) {
    suspend fun execute() = cartRepository.getCart()
}