package com.bharatmatrimony.theme.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ApiLoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.size(48.dp), color = Color.Yellow)
    }
}
