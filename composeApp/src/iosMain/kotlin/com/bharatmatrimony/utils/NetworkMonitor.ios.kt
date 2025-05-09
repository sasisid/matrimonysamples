package com.bharatmatrimony.utils

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.SystemConfiguration.SCNetworkReachabilityCreateWithName
import platform.SystemConfiguration.SCNetworkReachabilityFlagsVar
import platform.SystemConfiguration.SCNetworkReachabilityGetFlags
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsConnectionRequired
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsReachable

@OptIn(ExperimentalForeignApi::class)
actual fun isNetworkAvailable(): Boolean {
    val reachability = SCNetworkReachabilityCreateWithName(null, "apple.com") ?: return false

    memScoped {
        val flags = alloc<SCNetworkReachabilityFlagsVar>()
        if (!SCNetworkReachabilityGetFlags(reachability, flags.ptr)) {
            return false
        }

        val reachable = flags.value and kSCNetworkReachabilityFlagsReachable != 0u
        val connectionRequired = flags.value and kSCNetworkReachabilityFlagsConnectionRequired != 0u

        return reachable && !connectionRequired
    }

}
