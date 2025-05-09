package com.bharatmatrimony.utils

import android.content.Context

actual object PlatformUtils {

    actual val platform: PlatformType = PlatformType.Android

    lateinit var appContext: Context  // Must be initialized in Application class
}