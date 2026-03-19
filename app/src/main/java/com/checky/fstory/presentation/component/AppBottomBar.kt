package com.checky.fstory.presentation.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.checky.fstory.presentation.navigation.container.NavItemContainer


@Composable
fun AppBottomBar(currentRoute:String?,onNavigate:(String)->Unit) {
    val items = listOf(
        NavItemContainer("settings","Settings", Icons.Default.Settings),
        NavItemContainer("home","Home" ,Icons.Default.Home),
        NavItemContainer("profile","Profile", Icons.Default.Person)
    )
//    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar {
        items.forEach { item ->
            val isSelected = currentRoute == item.route

       AppItem (
           navItem = item,
           isSelected=isSelected,
           onItemClick = {onNavigate(item.route)})
//        itemList.forEachIndexed {( index, item) ->
//            AppItem(navItem = item, isSelected = index == selectedIndex) {
//                selectedIndex = index
            }
        }
    }


@Composable
fun RowScope.AppItem(
    navItem: NavItemContainer,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { onItemClick() },
        label = { Text(navItem.name) },
        alwaysShowLabel = false,
        icon = {
            Icon(
                imageVector = navItem.icon,
                contentDescription = navItem.name
            )
        }
    )
}

