package com.checky.fstory.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ImageFadeBackground(
    imageRes: Int,
    modifier: Modifier = Modifier,
    startFadeAt: Float = 0.6f,
    darkness: Float = 1f,
    isVertical: Boolean = true,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {

        // 🔹 Imagen base
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        val brush = if (isVertical) {
            Brush.verticalGradient(
                colorStops = arrayOf(
                    0.0f to Color.Transparent,
                    startFadeAt to Color.Transparent,
                    1.0f to Color.Black.copy(alpha = darkness)
                )
            )
        } else {
            Brush.horizontalGradient(
                colorStops = arrayOf(
                    0.0f to Color.Transparent,
                    startFadeAt to Color.Transparent,
                    1.0f to Color.Black.copy(alpha = darkness)
                )
            )
        }

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(brush)
        )

        content()
    }
}