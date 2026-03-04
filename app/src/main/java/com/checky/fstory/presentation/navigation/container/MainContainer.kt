package com.checky.fstory.ui.presentation.navigation.container

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.checky.fstory.ui.presentation.component.AppBottomBar
import com.checky.fstory.ui.presentation.screen.mainContainer.main.MainScreen
import com.checky.fstory.ui.presentation.screen.mainContainer.profile.ProfileScreen
import com.checky.fstory.ui.presentation.screen.mainContainer.settings.SettingScreen

@Composable
fun MainContainer() {

    val navController = rememberNavController()

    val navBackStackEntry = navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry.value?.destination?.route
    Scaffold(
        bottomBar = {
            AppBottomBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
            )
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {

            composable("home") {
                MainScreen(
                    navigateToProfile = { navController.navigate("profile") }
                )
            }
            composable("profile") {
                ProfileScreen(
                    navigateBack = { navController.popBackStack() }
                )
            }
            composable("settings") {
                SettingScreen()
            }
        }
    }
}