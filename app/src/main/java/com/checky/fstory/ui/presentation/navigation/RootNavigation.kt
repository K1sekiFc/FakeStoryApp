//package com.abexa.myapplication1.ui.presentation.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.navigation.NavHost
//import androidx.navigation.compose.rememberNavController
//import com.abexa.myapplication1.ui.data.datasource.preferences.SessionDataStore
//import kotlinx.coroutines.flow.first
//
//@Composable
//fun RootNavigation(session: SessionDataStore) {
//
//    val navController = rememberNavController()
//
//    var startDestination by remember { mutableStateOf<String?>(null) }
//
//    LaunchedEffect(Unit) {
//        val token = session.getToken.first()
//
//        startDestination = if (token != null) {
//            NavRoutes.Main
//        } else {
//            NavRoutes.Login
//        }
//    }
//    startDestination?.let { destination ->
//        NavHost(
//            navController = navController,
//
//        )
//    }
//
//}