package com.bharatmatrimony.utils

import io.ktor.client.HttpClient
import okio.Path
import okio.Path.Companion.toPath

enum class PlatformType {
    Android, iOS, Desktop, Web
}

expect object PlatformUtils {
    val platform: PlatformType

}