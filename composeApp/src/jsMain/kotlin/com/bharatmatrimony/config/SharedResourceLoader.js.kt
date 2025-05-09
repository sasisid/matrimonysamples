@file:OptIn(DelicateCoroutinesApi::class)

package com.bharatmatrimony.config

import kotlinx.browser.window
import kotlinx.coroutines.await

import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch

private val stringCache: MutableMap<String, Map<String, String>> = mutableMapOf()
private val loadedPaths: MutableSet<String> = mutableSetOf()
private val existingResources: MutableSet<String> = mutableSetOf()

actual fun loadProperties(path: String): Map<String, String> {
    // Return cache if already loaded
    stringCache[path]?.let { return it }

    // Kick off async loading in background (won't block caller)
    if (path !in loadedPaths) {
        loadedPaths.add(path)
        GlobalScope.launch {
            try {
                val response = window.fetch("/$path").await()
                if (response.ok) {
                    val text = response.text().await()
                    val props = text.lines()
                        .filter { it.contains("=") }
                        .associate {
                            val (k, v) = it.split("=", limit = 2)
                            k.trim() to v.trim()
                        }
                    stringCache[path] = props
                }
            } catch (_: Exception) {
                // ignore fetch error, keep as empty
            }
        }
    }

    return emptyMap()
}

actual fun resourceExists(path: String): Boolean {
    return path in existingResources
}

// Optional: preload image path
fun preloadImage(path: String) {
    GlobalScope.launch {
        try {
            val res = window.fetch("/$path").await()
            if (res.ok) {
                existingResources.add(path)
            }
        } catch (_: Exception) {}
    }
}