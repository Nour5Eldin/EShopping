package com.noureldin.eshopping.di


import com.noureldin.eshopping.ui.feature.cart.CartViewModel
import com.noureldin.eshopping.ui.feature.home.HomeViewModel
import com.noureldin.eshopping.ui.feature.product_details.ProductDetailsViewModel
import com.noureldin.eshopping.ui.feature.summary.CartSummaryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get(), get())
    }
    viewModel {
        ProductDetailsViewModel(get())
    }
    viewModel {
        CartViewModel(get(),get(),get())
    }
    viewModel {
        CartSummaryViewModel(get())
    }
}