package com.noureldin.domain.usecase

import com.noureldin.domain.model.CartItemModel
import com.noureldin.domain.repository.CartRepository

class UpdateQuantityUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(cartItemModel: CartItemModel) = cartRepository.updateQuantity(cartItemModel)
}