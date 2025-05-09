@file:Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
package com.bharatmatrimony.core.security


import kotlin.text.toString
import kotlin.toString
actual object AESUtil {

    actual fun encrypt(input: String): String {
        val aesKey = SecureSettings.getOrCreateAESKey()
        return try {
            AES.encrypt(input, aesKey.toString()).toString()
        } catch (e: dynamic) {
            console.error("⚠️ Web AES Encryption failed:", e)
            input
        }
    }

    actual fun decrypt(encrypted: String): String {
        if (encrypted.isEmpty()) return ""

        return try {
            val aesKey = SecureSettings.getOrCreateAESKey()
            AES.decrypt(encrypted, aesKey.toString())
                .toString(Enc.Utf8)
                ?.toString() ?: encrypted
        } catch (e: dynamic) {
            console.error("⚠️ Web AES Decryption failed:", e)
            encrypted
        }
    }
}
