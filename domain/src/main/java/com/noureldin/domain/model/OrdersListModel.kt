package com.noureldin.domain.model

import com.noureldin.domain.model.OrdersData

data class OrdersListModel(
    val `data`: List<OrdersData>,
    val msg: String
)