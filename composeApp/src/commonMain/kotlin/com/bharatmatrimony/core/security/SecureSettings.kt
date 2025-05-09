@file:OptIn(ExperimentalEncodingApi::class)
package com.bharatmatrimony.core.security

import com.russhwolf.settings.Settings
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.random.Random

object SecureSettings {
    private lateinit var settings: Settings

    private const val AES_KEY_ALIAS = "MatrimonyAESKey"

    fun initialize(settings: Settings) {
        this.settings = settings
    }

    fun getOrCreateAESKey(): ByteArray {
        val existing = settings.getStringOrNull(AES_KEY_ALIAS)
        if (existing != null) {
            return Base64.decode(existing)
        }

        val generatedKey = Random.Default.nextBytes(32)
        val encodedKey = Base64.encode(generatedKey)
        settings.putString(AES_KEY_ALIAS, encodedKey)
        return generatedKey
    }
}
