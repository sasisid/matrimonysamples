package com.bharatmatrimony.core.security

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
@OptIn(ExperimentalEncodingApi::class)
actual object AESUtil {
    actual fun encrypt(input: String): String {
        val key = Base64.encode(SecureSettings.getOrCreateAESKey())
        return SwiftCryptoBridge.encryptHandler?.invoke(input, key)
            ?: throw Exception("iOS Encryption failed: SwiftCryptoBridge handler missing")
    }

    actual fun decrypt(encrypted: String): String {
        if (encrypted.isEmpty()) return ""

        return try {
            val key = Base64.encode(SecureSettings.getOrCreateAESKey())
            SwiftCryptoBridge.decryptHandler?.invoke(encrypted, key) ?: encrypted
        } catch (e: Throwable) {
            println("⚠️ iOS AES Decryption failed: ${e.printStackTrace()}")
            encrypted
        }
    }
}
