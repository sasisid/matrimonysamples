package com.bharatmatrimony.config

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.*

@OptIn(ExperimentalForeignApi::class)
actual fun loadProperties(path: String): Map<String, String> {
    return try {
        val bundle = NSBundle.mainBundle
        val url = bundle.pathForResource(path, null) ?: return emptyMap()
        val content = NSString.stringWithContentsOfFile(url, NSUTF8StringEncoding, null) ?: return emptyMap()
        content
            .split("\n")
            .filter { it.contains("=") }
            .associate {
                val (k, v) = it.split("=", limit = 2)
                k.trim() to v.trim()
            }
    } catch (e: Exception) {
        emptyMap()
    }
}

actual  fun resourceExists(path: String): Boolean {
    val resourcePath = NSBundle.mainBundle.pathForResource(name = path, ofType = null)
    return resourcePath != null
}