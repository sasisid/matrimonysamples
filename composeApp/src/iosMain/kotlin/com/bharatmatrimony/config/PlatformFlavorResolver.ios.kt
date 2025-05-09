package com.bharatmatrimony.config

import platform.Foundation.NSBundle
import platform.Foundation.NSDictionary
import platform.Foundation.NSString
import platform.Foundation.allKeys

actual object PlatformFlavorResolver {
    private val infoDict: NSDictionary = NSBundle.mainBundle.infoDictionary!! as NSDictionary
    private val bundle = NSBundle.mainBundle
    init {
        println("🔍 CFBundleIdentifier = ${bundle.bundleIdentifier}")
        println("🔍 CFBundleDisplayName = ${bundle.objectForInfoDictionaryKey("CFBundleDisplayName")}")
        println("🔍 Executable name = ${bundle.objectForInfoDictionaryKey("CFBundleExecutable")}")
        println("🔍 Bundle path = ${bundle.bundlePath}")
        println("🔍 APP_FLAVOR = ${bundle.objectForInfoDictionaryKey("APP_FLAVOR")}")
        println("🔍 APP_TYPE = ${bundle.objectForInfoDictionaryKey("APP_TYPE")}")
        println("🔍 APP_TYPE = ${bundle.objectForInfoDictionaryKey("CFBundleIcons")}")

    }
//    init {
//        infoDict.allKeys.forEach { key ->
//            val value = infoDict.objectForKey(key)
//            println("INFO: $key = $value")
//        }
//    }

    actual val flavorName: String =
        infoDict.objectForKey("APP_FLAVOR")?.toString() ?: "base"

    actual val appType: Int =
        infoDict.objectForKey("APP_TYPE")?.toString()?.toIntOrNull() ?: 0
}
