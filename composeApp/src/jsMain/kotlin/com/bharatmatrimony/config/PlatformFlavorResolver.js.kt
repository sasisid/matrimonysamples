package com.bharatmatrimony.config

import kotlinx.browser.window

actual object PlatformFlavorResolver {
    private val knownFlavors = mapOf(
        "bharatmatrimony.com" to Pair("bharatmatrimony", 104),
        "tamilmatrimony.com" to Pair("tamilmatrimony", 131),
        "kannadamatrimony.com" to Pair("kannadamatrimony", 136),
        "punjabimatrimony.com" to Pair("punjabimatrimony", 139),
        "bengalimatrimony.com" to Pair("bengalimatrimony", 133),
        "oriyamatrimony.com" to Pair("oriyamatrimony", 137),
        "keralamatrimony.com" to Pair("keralamatrimony", 132),
        "marathimatrimony.com" to Pair("marathimatrimony", 135),
        "gujaratimatrimony.com" to Pair("gujaratimatrimony", 138),
        "telugumatrimony.com" to Pair("telugumatrimony", 134),
        "hindimatrimony.com" to Pair("hindimatrimony", 140),
        "marwadimatrimony.com" to Pair("marwadimatrimony", 141),
        "urdumatrimony.com" to Pair("urdumatrimony", 142),
        "assamesematrimony.com" to Pair("assamesematrimony", 143),
        "sindhimatrimony.com" to Pair("sindhimatrimony", 145),
        "biharimatrimony.com" to Pair("biharimatrimony", 146),
        "rajasthanimatrimony.com" to Pair("rajasthanimatrimony", 147),
        "bhojpurimatrimony.com" to Pair("bhojpurimatrimony", 148)
    )

    private val resolved = run {
        val host = window.location.hostname
        knownFlavors[host] ?: "base" to 0
    }

    actual val flavorName: String = resolved.first
    actual val appType: Int = resolved.second
}