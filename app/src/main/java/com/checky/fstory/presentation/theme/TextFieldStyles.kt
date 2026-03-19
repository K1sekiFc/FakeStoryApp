package com.checky.fstory.theme

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import com.checky.fstory.presentation.theme.White40

import androidx.compose.ui.graphics.Brush
import androidx.compose.material3.MaterialTheme
import com.checky.fstory.presentation.theme.Purple10


@Composable
fun defaultOutlinedTextFieldColors() =
    OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
        unfocusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
        disabledTextColor = MaterialTheme.colorScheme.onTertiaryContainer,
        errorTextColor = MaterialTheme.colorScheme.onErrorContainer,

        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
        disabledLabelColor = MaterialTheme.colorScheme.tertiary,
        errorLabelColor = MaterialTheme.colorScheme.error,


        focusedContainerColor = MaterialTheme.colorScheme.background,
        unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledContainerColor = MaterialTheme.colorScheme.tertiary,
        errorContainerColor = MaterialTheme.colorScheme.errorContainer
    )

@Composable
fun defaultOutlinedBorderGradient(): Brush =
    Brush.radialGradient(
        colors = listOf(
            White40,
            Purple10
        )
    )
