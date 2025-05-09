package com.bharatmatrimony.core.di

import com.bharatmatrimony.core.prefs.MultiplatformSettingsFactory
import com.bharatmatrimony.core.security.SecureSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.module

val jsModules = module {
    single { MultiplatformSettingsFactory() }

    single<Settings> {
        val settings = MultiplatformSettingsFactory().getSettings()
        SecureSettings.initialize(settings)
        settings
    }

}

suspend fun initKoinJs(){
    initKoin(additionalModules = listOf(jsModules))
}