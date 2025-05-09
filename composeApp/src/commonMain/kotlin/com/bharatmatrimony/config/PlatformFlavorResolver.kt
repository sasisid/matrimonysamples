package com.bharatmatrimony.config


expect object PlatformFlavorResolver {
    val flavorName: String
    val appType: Int
}