package com.checky.fstory.ui.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import com.checky.fstory.ui.presentation.navigation.container.NavItemContainer


@Composable
fun AppBottomBar(currentRoute:String?,onNavigate:(String)->Unit) {
    val items = listOf(
        NavItemContainer("Settings", Icons.Default.Settings),
        NavItemContainer("Home", Icons.Default.Home),
        NavItemContainer("Profile", Icons.Default.Person)
    )
//    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar {
        items.forEach { (route, icon) ->
        NavigationBarItem(
            selected = currentRoute == route,
            onClick = { onNavigate(route) },
            icon = { Icon(icon, contentDescription = null) },
            alwaysShowLabel = false
        )
//        itemList.forEachIndexed {( index, item) ->
//            AppItem(navItem = item, isSelected = index == selectedIndex) {
//                selectedIndex = index
            }
        }
    }


//@Composable
//fun RowScope.AppItem(navItem: NavItem, isSelected: Boolean, onItemClick:()->Unit) {
//    NavigationBarItem(
//        selected = (isSelected),
//        onClick = { onItemClick ()},
//        label = { Text(navItem.name) },
//        alwaysShowLabel = false,
//        icon = {
//            Icon(imageVector = navItem.icon, contentDescription = null)
//        },
//    )
//}


