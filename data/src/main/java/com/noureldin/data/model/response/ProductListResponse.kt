package com.noureldin.data.model.response

import com.noureldin.data.model.DataProductModel
import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(
    val `data`: List<DataProductModel>,
    val msg: String
) {
    fun toProductList() = com.noureldin.domain.model.ProductListModel(
        products = `data`.map { it.toProduct() },
        msg = msg
    )
}
