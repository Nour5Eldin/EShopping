package com.noureldin.domain.network

import com.noureldin.domain.model.AddressDomainModel
import com.noureldin.domain.model.CartItemModel
import com.noureldin.domain.model.CartModel
import com.noureldin.domain.model.CartSummary
import com.noureldin.domain.model.CategoriesListModel
import com.noureldin.domain.model.OrdersListModel
import com.noureldin.domain.model.ProductListModel
import com.noureldin.domain.model.request.AddCartRequestModel

interface NetworkService {
    suspend fun getProduct(category: Int?): ResultWrapper<ProductListModel>
    suspend fun getCategories(): ResultWrapper<CategoriesListModel>

    suspend fun addProductToCart(request: AddCartRequestModel): ResultWrapper<CartModel>

    suspend fun getCart(): ResultWrapper<CartModel>
    suspend fun updateQuantity(cartItemModel: CartItemModel): ResultWrapper<CartModel>
    suspend fun deleteItem(cartItemId: Int, userId: Int): ResultWrapper<CartModel>
    suspend fun getCartSummary(userId: Int): ResultWrapper<CartSummary>
    suspend fun placeOrder(address: AddressDomainModel, userId: Long): ResultWrapper<Long>
    suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel>
}
sealed class ResultWrapper<out T>{
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class Failure(val exception: Exception): ResultWrapper<Nothing>()
}