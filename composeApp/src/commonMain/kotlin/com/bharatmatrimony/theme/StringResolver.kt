package com.bharatmatrimony.theme

import com.bharatmatrimony.config.PlatformFlavorResolver

object StringResolver {
    private val flavorName = PlatformFlavorResolver.flavorName

    fun getString(key: String): String {
        println("✅ FLAVOR = $flavorName")
        println("✅ APP_TYPE = ${PlatformFlavorResolver.appType}")
        return FlavorStrings.get(key, flavorName)
            ?: CommonStrings.get(key)
    }
}



