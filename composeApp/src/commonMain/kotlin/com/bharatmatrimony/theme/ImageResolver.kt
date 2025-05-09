package com.bharatmatrimony.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.bharatmatrimony.config.PlatformFlavorResolver
import matrimony_kmp.composeapp.generated.resources.Res
import matrimony_kmp.composeapp.generated.resources.ic_cyclone
import matrimony_kmp.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

object ImageResolver {
    private val flavorName = PlatformFlavorResolver.flavorName

    @Composable
    fun getPainter(key: String): Painter {
        val flavoredKey = "${flavorName}_${key}"
        println("flavoredKey $flavoredKey")
        return when (flavoredKey) {
            "tamilmatrimony_logo" -> painterResource(Res.drawable.logo)
            else -> painterResource(Res.drawable.ic_cyclone)
        }
    }
}
