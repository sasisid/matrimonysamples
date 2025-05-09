package com.bharatmatrimony.config

import com.bharatmatrimony.BuildConfig

actual object PlatformFlavorResolver {
    actual val flavorName: String = BuildConfig.FLAVOR // Comes from Gradle productFlavors
    actual val appType: Int = BuildConfig.appType      // Comes from buildConfigField
}