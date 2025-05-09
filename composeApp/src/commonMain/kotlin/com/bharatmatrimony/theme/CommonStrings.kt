package com.bharatmatrimony.theme

object CommonStrings {
    fun get(key: String): String = when (key) {
        "cyclone" -> "Cyclone"
        "run" -> "Run"
        "stop" -> "Stop"
        "theme" -> "Theme"
        "open_github" -> "Open GitHub"
        else -> "[missing:$key]"
    }
}


