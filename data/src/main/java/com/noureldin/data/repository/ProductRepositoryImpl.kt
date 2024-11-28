package com.noureldin.data.repository


import com.noureldin.domain.model.ProductListModel
import com.noureldin.domain.network.NetworkService
import com.noureldin.domain.network.ResultWrapper
import com.noureldin.domain.repository.ProductRepository

class ProductRepositoryImpl(val networkService: NetworkService):ProductRepository {
    override suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel> {
        return networkService.getProduct(category)
    }
}