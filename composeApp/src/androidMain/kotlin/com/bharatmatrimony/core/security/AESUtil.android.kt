package com.bharatmatrimony.core.security

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

actual object AESUtil {
    private const val AES = "AES"
    private const val AES_MODE = "AES/GCM/NoPadding"
    private const val IV_SIZE = 12
    private const val TAG_LENGTH = 128

    actual fun encrypt(input: String): String {
        val key = SecureSettings.getOrCreateAESKey()
        val keySpec = SecretKeySpec(key, AES)

        val cipher = Cipher.getInstance(AES_MODE)
        val iv = ByteArray(IV_SIZE) { (0..255).random().toByte() }
        val spec = GCMParameterSpec(TAG_LENGTH, iv)
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, spec)

        val cipherText = cipher.doFinal(input.toByteArray())
        val combined = iv + cipherText

        return Base64.encodeToString(combined, Base64.NO_WRAP)
    }

    actual fun decrypt(encrypted: String): String {
        if (encrypted.isEmpty()) return "" // Safe fallback

        return try {
            val key = SecureSettings.getOrCreateAESKey()
            val decoded = Base64.decode(encrypted, Base64.NO_WRAP)

            val iv = decoded.copyOfRange(0, IV_SIZE)
            val cipherBytes = decoded.copyOfRange(IV_SIZE, decoded.size)

            val cipher = Cipher.getInstance(AES_MODE)
            val spec = GCMParameterSpec(TAG_LENGTH, iv)
            cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, AES), spec)

            val decrypted = cipher.doFinal(cipherBytes)
            String(decrypted)
        } catch (e: Throwable) {
            println("⚠️ Android AES Decryption failed: ${e.localizedMessage}")
            encrypted
        }
    }}
