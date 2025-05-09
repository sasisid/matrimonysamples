package com.bharatmatrimony.core.prefs

import com.russhwolf.settings.Settings



expect class MultiplatformSettingsFactory {
    fun getSettings():  Settings
}