package com.noureldin.eshopping

import android.app.Application
import com.noureldin.data.di.dataModule
import com.noureldin.domain.di.domainModule
import com.noureldin.eshopping.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EShoppingApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EShoppingApp)
            modules(listOf(
                presentationModule,
                dataModule,
                domainModule
            ))
        }
    }
}