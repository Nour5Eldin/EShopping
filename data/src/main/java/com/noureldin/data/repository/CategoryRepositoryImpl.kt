package com.noureldin.data.repository

import com.noureldin.domain.model.CategoriesListModel
import com.noureldin.domain.network.NetworkService
import com.noureldin.domain.network.ResultWrapper
import com.noureldin.domain.repository.CategoryRepository

class CategoryRepositoryImpl(val networkService: NetworkService) : CategoryRepository {
    override suspend fun getCategories(): ResultWrapper<CategoriesListModel> {
        return networkService.getCategories()
    }
}