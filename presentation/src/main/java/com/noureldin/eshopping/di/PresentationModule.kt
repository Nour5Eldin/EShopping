package com.noureldin.eshopping.di

import org.koin.dsl.module

val presentationModule = module {
    includes(viewModelModule)
}