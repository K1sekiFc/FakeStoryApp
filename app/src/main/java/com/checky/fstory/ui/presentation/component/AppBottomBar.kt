package com.checky.fstory.ui.presentation.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.checky.fstory.ui.presentation.navigation.NavItem


@Composable
fun AppBottomBar(modifier: Modifier = Modifier) {
    val itemList = listOf(
        NavItem("Notificaciones", Icons.Default.Notifications),
        NavItem("Home", Icons.Default.Home),
        NavItem("Settings", Icons.Default.Settings)
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar {
        itemList.forEachIndexed { index, item ->
            AppItem(navItem = item, isSelected = index == selectedIndex) {
                selectedIndex = index
            }

        }
    }
}

@Composable
fun RowScope.AppItem(navItem: NavItem, isSelected: Boolean, onItemClick:()->Unit) {
    NavigationBarItem(
        selected = (isSelected),
        onClick = { onItemClick ()},
        label = { Text(navItem.name) },
        alwaysShowLabel = false,
        icon = {
            Icon(imageVector = navItem.icon, contentDescription = null)
        },
    )
}


