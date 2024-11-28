package com.noureldin.data.repository


import com.noureldin.domain.model.AddressDomainModel
import com.noureldin.domain.model.OrdersListModel
import com.noureldin.domain.network.NetworkService
import com.noureldin.domain.network.ResultWrapper
import com.noureldin.domain.repository.OrderRepository

class OrderRepositoryImpl(private val networkService: NetworkService) : OrderRepository {
    override suspend fun placeOrder(
        addressDomainModel: AddressDomainModel,
        userId: Long
    ): ResultWrapper<Long> {
        return networkService.placeOrder(addressDomainModel, userId)
    }

    override suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel> {
        return networkService.getOrderList(userId)
    }
}