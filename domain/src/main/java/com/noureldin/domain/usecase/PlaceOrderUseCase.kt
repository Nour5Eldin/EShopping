package com.noureldin.domain.usecase

import com.noureldin.domain.model.AddressDomainModel
import com.noureldin.domain.repository.OrderRepository


class PlaceOrderUseCase(val orderRepository: OrderRepository) {
    suspend fun execute(addressDomainModel: AddressDomainModel, userId: Long) =
        orderRepository.placeOrder(addressDomainModel,userId)
}