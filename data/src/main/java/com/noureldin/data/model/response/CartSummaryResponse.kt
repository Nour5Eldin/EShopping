package com.noureldin.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CartSummaryResponse(
    val `data`: Summary,
    val msg: String
) {
    fun toCartSummary() = com.noureldin.domain.model.CartSummary(
        data = `data`.toSummaryData(),
        msg = msg
    )
}
