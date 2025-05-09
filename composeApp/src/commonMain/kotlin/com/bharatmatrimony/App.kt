package com.bharatmatrimony

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.bharatmatrimony.core.prefs.AppPreferences
import com.bharatmatrimony.core.security.AESUtil
import com.bharatmatrimony.theme.AppTheme
import com.bharatmatrimony.theme.ImageResolver
import com.bharatmatrimony.theme.LocalThemeIsDark
import com.bharatmatrimony.theme.StringResolver
import kotlinx.coroutines.isActive
import matrimony_kmp.composeapp.generated.resources.Res
import matrimony_kmp.composeapp.generated.resources.click
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Preview
@Composable
internal fun App() = AppTheme {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val title = StringResolver.getString("appname")
        val pref:AppPreferences = koinInject()
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall
        )

        var isRotating by remember { mutableStateOf(false) }

        val rotate = remember { Animatable(0f) }
        val target = 360f
        if (isRotating) {
            LaunchedEffect(Unit) {
                while (isActive) {
                    val remaining = (target - rotate.value) / target
                    rotate.animateTo(target, animationSpec = tween((1_000 * remaining).toInt(), easing = LinearEasing))
                    rotate.snapTo(0f)
                }
            }
        }

        Image(
            modifier = Modifier
                .size(250.dp)
                .padding(16.dp)
                .run { rotate(rotate.value) },
            painter = ImageResolver.getPainter("logo"),
            contentDescription = null
        )


        var isDark by LocalThemeIsDark.current




        val uriHandler = LocalUriHandler.current
        TextButton(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
            onClick = { uriHandler.openUri("https://www.tamilmatrimony.com/") },
        ) {
            Text(stringResource(Res.string.click))
        }
        pref.putString("uname","sasi")
        Text("normal encryption ${AESUtil.encrypt("matrimony")}")
        Text(" shared pref ${pref.getString("uname","")}")

    }
}
