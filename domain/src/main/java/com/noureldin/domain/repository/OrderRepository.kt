package com.noureldin.domain.repository

import com.noureldin.domain.model.AddressDomainModel
import com.noureldin.domain.model.OrdersListModel
import com.noureldin.domain.network.ResultWrapper

interface OrderRepository {
    suspend fun placeOrder(addressDomainModel: AddressDomainModel, userId: Long): ResultWrapper<Long>
    suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel>
}