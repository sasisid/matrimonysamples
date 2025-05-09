package com.bharatmatrimony.web

import kotlinx.browser.window

object WebFlavorResolver {
    data class Flavor(val name: String, val appType: Int)

    private val knownFlavors = mapOf(
        "bharatmatrimony.com" to Flavor("bharatmatrimony", 104),
        "tamilmatrimony.com" to Flavor("tamilmatrimony", 131),
        "kannadamatrimony.com" to Flavor("kannadamatrimony", 136),
        "punjabimatrimony.com" to Flavor("punjabimatrimony", 139),
        "bengalimatrimony.com" to Flavor("bengalimatrimony", 133),
        "oriyamatrimony.com" to Flavor("oriyamatrimony", 137),
        "keralamatrimony.com" to Flavor("keralamatrimony", 132),
        "marathimatrimony.com" to Flavor("marathimatrimony", 135),
        "gujaratimatrimony.com" to Flavor("gujaratimatrimony", 138),
        "telugumatrimony.com" to Flavor("telugumatrimony", 134),
        "hindimatrimony.com" to Flavor("hindimatrimony", 140),
        "marwadimatrimony.com" to Flavor("marwadimatrimony", 141),
        "urdumatrimony.com" to Flavor("urdumatrimony", 142),
        "assamesematrimony.com" to Flavor("assamesematrimony", 143),
        "sindhimatrimony.com" to Flavor("sindhimatrimony", 145),
        "biharimatrimony.com" to Flavor("biharimatrimony", 146),
        "rajasthanimatrimony.com" to Flavor("rajasthanimatrimony", 147),
        "bhojpurimatrimony.com" to Flavor("bhojpurimatrimony", 148)
    )

    val currentFlavor: Flavor by lazy {
        val host = window.location.hostname
        knownFlavors[host] ?: Flavor("base", 0) // fallback to base
    }
}