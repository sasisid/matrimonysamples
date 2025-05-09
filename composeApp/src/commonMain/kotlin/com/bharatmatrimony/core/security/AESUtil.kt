package com.bharatmatrimony.core.security

expect object AESUtil {
    fun encrypt(input: String): String
    fun decrypt(encrypted: String): String
}