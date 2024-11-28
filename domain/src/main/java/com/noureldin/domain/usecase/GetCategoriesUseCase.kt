package com.noureldin.domain.usecase

import com.noureldin.domain.repository.CategoryRepository

class GetCategoriesUseCase (private val repository: CategoryRepository) {
    suspend fun execute() = repository.getCategories()
}