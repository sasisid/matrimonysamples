package com.bharatmatrimony

import android.app.Application
import com.bharatmatrimony.core.di.initKoin
import com.bharatmatrimony.core.prefs.MultiplatformSettingsFactory
import com.bharatmatrimony.core.security.SecureSettings
import com.bharatmatrimony.utils.PlatformUtils
import com.russhwolf.settings.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class MatrimonyApplication : Application() {
    private val androidModules = module {
        single<Settings> {
            val settings = MultiplatformSettingsFactory(get()).getSettings()
            SecureSettings.initialize(settings)
            settings
        }
        single { MultiplatformSettingsFactory(applicationContext) }


    }

    override fun onCreate() {
        super.onCreate()
        PlatformUtils.appContext = applicationContext

        setupKoin()
    }

    private fun setupKoin() {
        CoroutineScope(Dispatchers.Default).launch {
            initKoin(additionalModules = listOf(androidModules)) {
                androidContext(applicationContext)
            }
        }
    }
}