package com.bharatmatrimony.theme.widgets

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun shakeOffset(isShaking: Boolean): Dp {
    val offset by animateDpAsState(
        targetValue = if (isShaking) 10.dp else 0.dp,
        animationSpec = repeatable(
            iterations = 3,
            animation = tween(durationMillis = 100, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "ShakeOffsetAnimation"
    )
    return offset
}
