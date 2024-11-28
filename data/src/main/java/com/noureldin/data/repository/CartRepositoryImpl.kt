package com.noureldin.data.repository

import com.noureldin.domain.model.CartItemModel
import com.noureldin.domain.model.CartModel
import com.noureldin.domain.model.CartSummary
import com.noureldin.domain.model.request.AddCartRequestModel
import com.noureldin.domain.network.NetworkService
import com.noureldin.domain.network.ResultWrapper
import com.noureldin.domain.repository.CartRepository

class CartRepositoryImpl (val networkService: NetworkService) : CartRepository {
    override suspend fun addProductToCart(request: AddCartRequestModel): ResultWrapper<CartModel> {
        return networkService.addProductToCart(request)
    }

    override suspend fun getCart(): ResultWrapper<CartModel> {
        return networkService.getCart()
    }

    override suspend fun updateQuantity(cartItemModel: CartItemModel): ResultWrapper<CartModel> {
        return networkService.updateQuantity(cartItemModel)
    }

    override suspend fun deleteItem(cartItemId: Int, userId: Int): ResultWrapper<CartModel> {
        return networkService.deleteItem(cartItemId,userId)
    }

    override suspend fun getCartSummary(userId: Int): ResultWrapper<CartSummary> {
        return networkService.getCartSummary(userId)
    }
}