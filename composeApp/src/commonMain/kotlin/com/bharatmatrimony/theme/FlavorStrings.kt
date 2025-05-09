package com.bharatmatrimony.theme

object FlavorStrings {
    fun get(key: String, flavor: String): String? = when (flavor) {
        "tamilmatrimony" -> when (key) {
            "appname" -> "தமிழ் மேட்ரிமோனி"
            else -> null
        }
        "assamesematrimony" -> when (key) {
            "appname" -> "অসমীয়া বিয়া"
            else -> null
        }
        else -> null
    }
}

