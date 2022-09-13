package com.owenlejeune.mydex.di

import com.owenlejeune.mydex.preferences.AppPreferences
import org.koin.dsl.module

val preferencesModule = module {
    single { AppPreferences(get()) }
}