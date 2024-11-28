package com.noureldin.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class OrdersListResponse(
    val `data`: List<OrderListData>,
    val msg: String
){
    fun toDomainResponse(): com.noureldin.domain.model.OrdersListModel {
        return com.noureldin.domain.model.OrdersListModel(
            `data` = `data`.map { it.toDomainResponse() },
            msg = msg
        )
    }
}
