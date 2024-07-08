package com.example.zaraestore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.zaraestore.model.Wear.Companion.clothe
import com.example.zaraestore.ui.screens.DataScreen
import com.example.zaraestore.ui.screens.DetailScreen
import com.example.zaraestore.ui.screens.HomeScreen
import com.example.zaraestore.ui.screens.NotificationScreen
import com.example.zaraestore.ui.screens.OrderScreen
import com.example.zaraestore.ui.screens.ReferenceSearchScreen
import com.example.zaraestore.ui.screens.ScannerSearchScreen

sealed class Screen(val route: String, val icon: ImageVector) {
    data object HomeScreen : Screen("home", Icons.Outlined.Home)
    data object ScannerSearchScreen : Screen("scanner", Icons.Outlined.Search)
    data object ReferenceSearchScreen : Screen("reference", Icons.Outlined.Search)
    data object DetailsScreen : Screen("detail", Icons.Outlined.Search)
    data object OrderScreen : Screen("order", Icons.Outlined.Search)
    data object DataScreen : Screen("data", Icons.Outlined.Search)
    data object NotificationScreen : Screen("notification", Icons.Outlined.Search)
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val items = listOf(
        Screen.HomeScreen,
        Screen.ReferenceSearchScreen
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(Modifier.background(color = Color.White)) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        modifier = Modifier.background(color = Color.White),
                        icon = { Icon(screen.icon, contentDescription = null) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.Gray,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.HomeScreen.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.HomeScreen.route) { HomeScreen() }
            composable(Screen.ReferenceSearchScreen.route) { ReferenceSearchScreen(navController) }
            composable(Screen.ScannerSearchScreen.route) { ScannerSearchScreen(navController) }
            composable(Screen.DetailsScreen.route) { DetailScreen(navController, clothe) }
            composable(Screen.OrderScreen.route) { OrderScreen(navController) }
            composable(Screen.DataScreen.route) { DataScreen(navController) }
            composable(Screen.NotificationScreen.route) { NotificationScreen(navController) }
        }
    }
}