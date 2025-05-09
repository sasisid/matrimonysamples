package com.bharatmatrimony.theme

object FlavorImages {
    fun get(key: String, flavor: String): String? = when (flavor) {
        "tamilmatrimony" -> when (key) {
            "logo" -> "tamilmatrimony/images/logo.png"
            else -> null
        }
        "assamesematrimony" -> when (key) {
            "logo" -> "assamesematrimony/images/logo.png"
            else -> null
        }
        else -> null
    }
}