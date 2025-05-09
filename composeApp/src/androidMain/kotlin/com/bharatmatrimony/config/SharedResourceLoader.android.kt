package com.bharatmatrimony.config

import android.content.Context
import com.bharatmatrimony.utils.PlatformUtils
import java.util.Properties

 var appContext: Context = PlatformUtils.appContext

actual fun loadProperties(path: String): Map<String, String> {
    println("🔍 Loading props from: $path")
    return try {
        val props = Properties()
        val stream = PlatformFlavorResolver::class.java.classLoader?.getResourceAsStream(path)

        if (stream == null) {
            println("❌ Resource stream is null for: $path")
            return emptyMap()
        }

        props.load(stream)
        props.entries.associate { it.key.toString() to it.value.toString() }
    } catch (e: Exception) {
        println("❌ Failed to load properties from $path: ${e.message}")
        emptyMap()
    }
}



actual  fun resourceExists(path: String): Boolean {
    return try {
        appContext.assets.open(path).close()
        true
    } catch (e: Exception) {
        false
    }
}