package com.example.zaraestore.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zaraestore.Screen
import com.example.zaraestore.model.Wear.Companion.loc
import com.example.zaraestore.model.Wear.Companion.notification

@Composable
fun DataScreen(navController: NavController) {
    var valueInput1 by remember { mutableStateOf("") }
    var valueInput2 by rememberSaveable { mutableStateOf("") }
    var valueInput3 by rememberSaveable { mutableStateOf("") }
    var valueInput4 by rememberSaveable { mutableStateOf("") }
    var valueInput5 by rememberSaveable { mutableStateOf("") }
    var valueInput6 by rememberSaveable { mutableStateOf("") }
    var valueInput7 by rememberSaveable { mutableStateOf("") }
    var valueInput8 by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(40.dp))
        Text(text = "INTRODUZCA SUS DATOS DE ENVÍO", color = Color.Black, fontWeight = Bold)
        Column {
            Spacer(modifier = Modifier.size(40.dp))
            OutlinedTextField(
                value = valueInput1,
                onValueChange = {
                    valueInput1 = it
                },
                label = { Text("Nombre") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(400.dp, 60.dp)
            )
            OutlinedTextField(
                value = valueInput2,
                onValueChange = {
                    valueInput2 = it
                },
                label = { Text("Apellidos") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(400.dp, 60.dp)
            )
            OutlinedTextField(
                value = valueInput3,
                onValueChange = {
                    valueInput3 = it
                },
                label = { Text("Teléfono") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(400.dp, 60.dp)
            )
            OutlinedTextField(
                value = valueInput4,
                onValueChange = {
                    valueInput4 = it
                },
                label = { Text("E-mail") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(400.dp, 60.dp)
            )
            if (loc == "casa") {
                OutlinedTextField(
                    value = valueInput5,
                    onValueChange = {
                        valueInput5 = it
                    },
                    label = { Text("Dirección") },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(400.dp, 60.dp)
                )
                OutlinedTextField(
                    value = valueInput6,
                    onValueChange = {
                        valueInput6 = it
                    },
                    label = { Text("Localidad") },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(400.dp, 60.dp)
                )
                OutlinedTextField(
                    value = valueInput7,
                    onValueChange = {
                        valueInput7 = it
                    },
                    label = { Text("Código Postal") },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(400.dp, 60.dp)
                )
            }
            if (loc == "punto") {
                OutlinedTextField(
                    value = valueInput8,
                    onValueChange = {
                        valueInput8 = it
                    },
                    label = { Text("Punto de recogida") },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(400.dp, 60.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(40.dp))
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black)
                .size(200.dp, 50.dp)
                .clickable {
                    notification = "Prenda encargada, nos pondremos en contacto con usted cuando esté disponible."
                    navController.navigate(Screen.NotificationScreen.route)
                }
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "ACEPTAR")
        }
    }
}