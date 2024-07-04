package com.example.zaraestore.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zaraestore.R
import com.example.zaraestore.Screen
import com.example.zaraestore.model.Wear

@Composable
fun ReferenceSearchScreen(navController: NavController) {
    var valueInput by rememberSaveable { mutableStateOf("") }
    Column {
        topBar(navController)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_barcode_wobg),
                contentDescription = null,
                modifier = Modifier.size(500.dp, 300.dp)
            )
            OutlinedTextField(
                value = valueInput,
                onValueChange = {
                    when (valueInput) {
                        "3067423064" -> {
                            Wear.clothe = Wear.boxers
                            valueInput = ""
                            navController.navigate(Screen.DetailsScreen.route)
                        }
                        "4749709250" -> {
                            Wear.clothe = Wear.chaleco
                            valueInput = ""
                            navController.navigate(Screen.DetailsScreen.route)
                        }
                        "1652310002" -> {
                            Wear.clothe = Wear.sandalias
                            valueInput = ""
                            navController.navigate(Screen.DetailsScreen.route)
                        }
                        "4442303712" -> {
                            Wear.clothe = Wear.shorts
                            valueInput = ""
                            navController.navigate(Screen.DetailsScreen.route)
                        }
                        else -> {
                            valueInput = it
                        }
                    }
                },
                label = { Text("Referencia del producto") },
                modifier = Modifier
                    .padding(16.dp)
                    .size(400.dp, 60.dp)
            )
        }
    }
}

@Composable
fun topBar(navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black)
                .padding(15.dp)
                .clickable { navController.navigate("scanner") },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.ic_camera), contentDescription = null)
            Text("ESCÁNER", color = Color.Black)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black)
                .padding(15.dp)
                .clickable { navController.navigate("reference") },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.ic_keyboard), contentDescription = null)
            Text("TECLADO", color = Color.Black)
        }
    }
}