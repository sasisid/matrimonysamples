package com.bharatmatrimony.config

object SharedResources {


    private val flavor = PlatformFlavorResolver.flavorName
    private val overrideStrings: Map<String, String> = loadProperties("$flavor/strings.properties")
    private val baseStrings: Map<String, String> = loadProperties("base/strings.properties")

    fun getString(key: String): String {
        println("keysss $flavor == $key  ${overrideStrings[key]} === ${baseStrings[key]}" )

        return overrideStrings[key] ?: baseStrings[key] ?: "[missing:$key]"
    }

    fun getImagePath(name: String): String {
        val flavorPath = "flavorResources/$flavor/images/$name"
        val basePath = "flavorResources/base/images/$name"
        return if (resourceExists(flavorPath)) flavorPath else basePath
    }

    val appType: Int = PlatformFlavorResolver.appType
}
