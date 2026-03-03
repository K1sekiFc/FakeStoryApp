package com.checky.fstory.ui.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class NavRoutes : NavKey {

    @Serializable
    object Welcome: NavRoutes()
    @Serializable
    object Login : NavRoutes()

    @Serializable
    object Register: NavRoutes()

    @Serializable
    object Main: NavRoutes()

    @Serializable
    object Profile: NavRoutes()

    @Serializable
    object Home: NavRoutes()

    @Serializable
    object  Ubication: NavRoutes()

    @Serializable
    object  Setting: NavRoutes()


}