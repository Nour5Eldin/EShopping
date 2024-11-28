package com.noureldin.domain.repository

import com.noureldin.domain.model.CategoriesListModel
import com.noureldin.domain.network.ResultWrapper

interface CategoryRepository {
    suspend fun getCategories(): ResultWrapper<CategoriesListModel>
}