package com.checky.fstory.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.checky.fstory.ui.presentation.screen.ubication.UbicationScreen

import com.checky.fstory.ui.presentation.screen.login.LoginScreen
import com.checky.fstory.ui.presentation.screen.main.MainScreen
import com.checky.fstory.ui.presentation.screen.profile.ProfileScreen
import com.checky.fstory.ui.presentation.screen.register.RegisterScreen
import com.checky.fstory.ui.presentation.screen.settings.SettingScreen
import com.checky.fstory.ui.presentation.screen.welcome.WelcomeScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
//
//    val backstack = remember { mutableStateListOf<Any>(NavRoutes.Welcome) }
//
//    NavDisplay(
//        backStack = backstack,
//        onBack = {backstack.removeLastOrNull()},
//        entryProvider = {key ->
//            when(key){
//                else -> NavEntry(key = Unit){
//                    Text("Error")
//                }
//            }
//        }
//    )

    NavHost(navController = navController, startDestination = NavRoutes.Welcome) {
        composable<NavRoutes.Welcome> {
            WelcomeScreen(
                navigateToLogin = { navController.navigate(NavRoutes.Login)
                { launchSingleTop = true }}
            )
        }
        composable<NavRoutes.Login> {
            LoginScreen(
                navigateToRegister = { navController.navigate(NavRoutes.Register) },
                navigateBack = { navController.popBackStack() },
                navigateToMain = {
                    navController.navigate(NavRoutes.Main) {
                        popUpTo(NavRoutes.Welcome) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<NavRoutes.Register> {
            RegisterScreen(
                navigateBack = { navController.popBackStack() },

                )
        }
        composable<NavRoutes.Setting> {
            SettingScreen()
        }
        composable<NavRoutes.Ubication> {
            UbicationScreen()
        }
        composable<NavRoutes.Main> {
            MainScreen(navigateToProfile = {
                navController.navigate(NavRoutes.Profile) {
                    launchSingleTop = true
                    restoreState = true
                }
            })
        }
        composable<NavRoutes.Profile> {
            ProfileScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}
