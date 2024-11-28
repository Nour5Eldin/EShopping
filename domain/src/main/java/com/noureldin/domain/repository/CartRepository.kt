package com.noureldin.domain.repository

import com.noureldin.domain.model.CartItemModel
import com.noureldin.domain.model.CartModel
import com.noureldin.domain.model.CartSummary
import com.noureldin.domain.model.request.AddCartRequestModel
import com.noureldin.domain.network.ResultWrapper

interface CartRepository {
    suspend fun addProductToCart(
        request: AddCartRequestModel
    ): ResultWrapper<CartModel>

    suspend fun getCart(): ResultWrapper<CartModel>
    suspend fun updateQuantity(cartItemModel: CartItemModel): ResultWrapper<CartModel>
    suspend fun deleteItem(cartItemId: Int, userId: Int): ResultWrapper<CartModel>
    suspend fun getCartSummary(userId: Int): ResultWrapper<CartSummary>
}