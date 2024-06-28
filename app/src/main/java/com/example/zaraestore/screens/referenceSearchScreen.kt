package com.example.zaraestore.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReferenceSearchScreen(navController: NavController) {
    Column {
        topBar(navController)
    }
}

@Composable
fun topBar(navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black)
                .padding(15.dp)
                .clickable { navController.navigate("reference") },
            contentAlignment = Alignment.Center
        ) {
            Text("Teclado", color = Color.Black)
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black)
                .padding(15.dp)
                .clickable { navController.navigate("scanner") },
            contentAlignment = Alignment.Center
        ) {
            Text("Escáner", color = Color.Black)
        }
    }
}