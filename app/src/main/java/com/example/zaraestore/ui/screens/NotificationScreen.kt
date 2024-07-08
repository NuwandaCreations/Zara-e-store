package com.example.zaraestore.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zaraestore.Screen
import com.example.zaraestore.model.Wear.Companion.notification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun NotificationScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = notification, fontSize = 25.sp)

    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            delay(5000)
            launch(Dispatchers.Main) {
                navController.navigate(Screen.HomeScreen.route)
            }
        }
    }
}
