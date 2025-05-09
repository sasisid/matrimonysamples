package com.bharatmatrimony.core.prefs

import com.bharatmatrimony.core.security.SecureSettings
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings

actual class MultiplatformSettingsFactory {
    actual fun getSettings(): Settings {
        val settings =  KeychainSettings(service = "com.bharatmatrimony.secureprefs")
        SecureSettings.initialize(settings)
        return settings

    }
}
