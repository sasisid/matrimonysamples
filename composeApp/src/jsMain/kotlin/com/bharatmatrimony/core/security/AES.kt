@file:JsModule("crypto-js")
@file:JsNonModule
package com.bharatmatrimony.core.security

@JsName("AES")
external object AES {
    fun encrypt(value: String, secret: String): dynamic
    fun decrypt(encrypted: String, secret: String): dynamic
}

@JsName("enc")
external object Enc {
    val Utf8: dynamic
}
