package com.keanequibilan.flashcards

import android.app.Application
import com.keanequibilan.di.DI_MODULES
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class FlashCardsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FlashCardsApp)
            modules(DI_MODULES)
        }
    }
}
