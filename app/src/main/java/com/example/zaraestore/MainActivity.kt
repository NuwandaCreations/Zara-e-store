package com.example.zaraestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zaraestore.ui.theme.ZaraEstoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
            ZaraEstoreTheme {

            }
        }
    }
    sealed class Screen(val route: String) {
        data object HomeScreen : Screen("home")
        data object ProductScreen : Screen("product")
    }
    @Composable
    private fun Navigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
            composable(Screen.HomeScreen.route) {
                Button(onClick = { navController.navigate(Screen.ProductScreen.route) }) {
                    Text(text = "Go to Product Screen")
                }
            }
            composable(Screen.ProductScreen.route) {
                Text(text = "Product Screen")
            }
        }
    }
}