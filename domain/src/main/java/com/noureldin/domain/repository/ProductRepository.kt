package com.noureldin.domain.repository

import com.noureldin.domain.model.ProductListModel
import com.noureldin.domain.network.ResultWrapper

interface ProductRepository {
    suspend fun getProducts(category:Int?): ResultWrapper<ProductListModel>
}