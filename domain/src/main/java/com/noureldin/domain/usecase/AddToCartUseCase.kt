package com.noureldin.domain.usecase

import com.noureldin.domain.model.request.AddCartRequestModel
import com.noureldin.domain.repository.CartRepository

class AddToCartUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(request: AddCartRequestModel) = cartRepository.addProductToCart(request)
}