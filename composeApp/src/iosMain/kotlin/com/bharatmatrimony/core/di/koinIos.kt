package com.bharatmatrimony.core.di

import com.bharatmatrimony.core.prefs.MultiplatformSettingsFactory
import com.bharatmatrimony.core.security.SecureSettings
import com.russhwolf.settings.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.dsl.module

val iosModule = module {

    single { MultiplatformSettingsFactory() }
    single<Settings> {
        val settings = MultiplatformSettingsFactory().getSettings()
        SecureSettings.initialize(settings)
        settings
    }
}

fun doInitKoinIos() {
    GlobalScope.launch(Dispatchers.Default) {
        initKoin(additionalModules = listOf(iosModule))
    }
}