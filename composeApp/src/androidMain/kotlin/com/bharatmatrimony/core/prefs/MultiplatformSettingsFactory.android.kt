package com.bharatmatrimony.core.prefs

import android.content.Context
import com.russhwolf.settings.Settings
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.bharatmatrimony.core.security.SecureSettings
import com.russhwolf.settings.SharedPreferencesSettings

private const val ANDROID_PREF_NAME = "android.pref"

actual class MultiplatformSettingsFactory(private val context: Context) {
    actual fun getSettings(): Settings {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val delegate = EncryptedSharedPreferences.create(
            context,
            ANDROID_PREF_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        val settings =  SharedPreferencesSettings(delegate)
        SecureSettings.initialize(settings)
        return settings
    }
}