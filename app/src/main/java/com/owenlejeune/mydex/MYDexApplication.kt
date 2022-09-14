package com.owenlejeune.mydex

import android.app.Application
import com.facebook.stetho.Stetho
import com.kieronquinn.monetcompat.core.MonetCompat
import com.owenlejeune.mydex.di.Modules
import com.owenlejeune.mydex.di.networkModule
import com.owenlejeune.mydex.di.preferencesModule
import com.owenlejeune.mydex.preferences.AppPreferences
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MYDexApplication: Application() {

    private val preferences: AppPreferences by inject()

    override fun onCreate() {
        super.onCreate()

        // start koin
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) Level.ERROR else Level.NONE
            )
            androidContext(this@MYDexApplication)
            modules(Modules)
        }

        MonetCompat.enablePaletteCompat()
        MonetCompat.chromaMultiplier = preferences.chromaMultiplier

        MonetCompat.wallpaperColorPicker = {
            val userPickedColor = preferences.selectedColor
            it?.firstOrNull { color -> color == userPickedColor } ?: it?.firstOrNull()
        }

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

}