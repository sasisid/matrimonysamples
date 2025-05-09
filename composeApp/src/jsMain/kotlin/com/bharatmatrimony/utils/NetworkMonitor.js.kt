package com.bharatmatrimony.utils

actual fun isNetworkAvailable(): Boolean {
    return js("navigator.onLine") as Boolean
}