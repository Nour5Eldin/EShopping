package com.noureldin.domain.usecase


import com.noureldin.domain.repository.OrderRepository

class OrderListUseCase(
    private val repository: OrderRepository
) {
    suspend fun execute(userId: Long) = repository.getOrderList(userId)
}