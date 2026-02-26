package com.abexa.Checky.ui.presentation.screen.ubication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abexa.Checky.ui.presentation.component.GradientBackground


@Composable
fun UbicationScreen () {
    GradientBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
//            topBar = { AppTopBarDef(title = "Checky", navigateBack = "null", subtitle = "") },
//            bottomBar= AppBottomBar(),
            containerColor = Color.Transparent
        ){ padding ->Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
        }
        }
    }
}