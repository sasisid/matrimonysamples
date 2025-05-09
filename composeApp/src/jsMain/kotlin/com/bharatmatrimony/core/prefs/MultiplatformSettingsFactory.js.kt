package com.bharatmatrimony.core.prefs

import com.bharatmatrimony.core.security.AESUtil
import com.bharatmatrimony.core.security.SecureSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import kotlinx.browser.window


actual class MultiplatformSettingsFactory {
    actual fun getSettings(): Settings {
        val raw = StorageSettings(window.localStorage)

        val settings =  object : Settings by raw {
            override fun putString(key: String, value: String) {
                try {
                    val encrypted = AESUtil.encrypt(value).toString()
                    raw.putString(key, encrypted)
                } catch (e: dynamic) {
                    console.error("Encryption failed:", e)
                    raw.putString(key, value)
                }
            }

            override fun getString(key: String, defaultValue: String): String {
                return try {
                    val encrypted = raw.getString(key, "")
                    if (encrypted.isEmpty()) return defaultValue

                    val decrypted = AESUtil.decrypt(encrypted).toString()


                    if (decrypted != "") decrypted else defaultValue
                } catch (e: dynamic) {
                    console.error("Decryption failed:", e)
                    defaultValue
                }
            }

        }
        SecureSettings.initialize(settings)
        return settings
    }
}
