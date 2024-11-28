package com.noureldin.data.di

import com.noureldin.data.repository.CategoryRepositoryImpl
import com.noureldin.data.repository.ProductRepositoryImpl
import com.noureldin.domain.repository.CartRepository
import com.noureldin.domain.repository.CategoryRepository
import com.noureldin.domain.repository.OrderRepository
import com.noureldin.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<CartRepository> { com.noureldin.data.repository.CartRepositoryImpl(get()) }
    single<OrderRepository> { com.noureldin.data.repository.OrderRepositoryImpl(get()) }
}