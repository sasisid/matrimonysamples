package com.bharatmatrimony.theme

object CommonImages {
    fun get(key: String): String = when (key) {
        "logo" -> "base/images/logo.png"
        "splash" -> "base/images/splash_logo.png"
        else -> "base/images/placeholder.png"
    }
}