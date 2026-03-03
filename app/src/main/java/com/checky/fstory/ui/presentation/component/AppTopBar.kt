@file:OptIn(ExperimentalMaterial3Api::class)

package com.checky.fstory.ui.presentation.component

import androidx.compose.foundation.layout.Row


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew


import androidx.compose.material3.CenterAlignedTopAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarDef(
    title: String,
    subtitle: (@Composable () -> Unit)? = null,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        },
        navigationIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {

                if (showBackButton && onBackClick != null) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = null
                        )
                    }
                }
                subtitle?.invoke()
            }
        },
        actions = {
            actions?.invoke()
        },
        colors = topBarColors()
    )
}


@Composable
private fun topBarColors() =  TopAppBarDefaults.topAppBarColors(
    containerColor = MaterialTheme.colorScheme.background,
    titleContentColor = MaterialTheme.colorScheme.onBackground,
    navigationIconContentColor = MaterialTheme.colorScheme.onBackground
)