package com.abexa.Checky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abexa.Checky.ui.presentation.navigation.NavigationWrapper
import com.abexa.Checky.ui.presentation.theme.MyApplication1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            MyApplication1Theme {
        NavigationWrapper()
            }
        }
    }
}


