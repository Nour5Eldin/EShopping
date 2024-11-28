package com.noureldin.domain.di

import com.noureldin.domain.usecase.AddToCartUseCase
import com.noureldin.domain.usecase.CartSummaryUseCase
import com.noureldin.domain.usecase.DeleteProductUseCase
import com.noureldin.domain.usecase.GetCartUseCase
import com.noureldin.domain.usecase.GetCategoriesUseCase
import com.noureldin.domain.usecase.GetProductUseCase
import com.noureldin.domain.usecase.UpdateQuantityUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { AddToCartUseCase(get()) }
    factory { GetCartUseCase(get()) }
    factory { UpdateQuantityUseCase(get()) }
    factory { DeleteProductUseCase(get()) }
    factory { CartSummaryUseCase(get()) }

}