package com.keanequibilan.flashcards

import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.keanequibilan.layer_di.LAYER_DI_MODULES
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class FlashCardsApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FlashCardsApp)
            modules(LAYER_DI_MODULES)
        }
        Stetho.initializeWithDefaults(this)
    }
}
