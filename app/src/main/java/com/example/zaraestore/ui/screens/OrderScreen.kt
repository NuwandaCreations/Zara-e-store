package com.example.zaraestore.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zaraestore.R
import com.example.zaraestore.Screen
import com.example.zaraestore.model.Wear
import com.example.zaraestore.model.Wear.Companion.loc

@Composable
fun OrderScreen(navController: NavController) {
    var valueInput by rememberSaveable { mutableStateOf("") }
    var selectedDay by remember {
        mutableStateOf(false)
    }
    Column {
        TopOrderBar(navController)
        Spacer(modifier = Modifier.size(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ARTÍCULOS")
            Spacer(modifier = Modifier.size(30.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_boxers2),
                contentDescription = null,
                modifier = Modifier.size(500.dp, 300.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Row(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "VIERNES 19 DE JULIO", color = Color.Black)
                Spacer(modifier = Modifier.size(40.dp))
                Text(text = "GRATUITO", textAlign = TextAlign.End, color = Color.Black)
            }
            Spacer(modifier = Modifier.size(70.dp))
            Box(
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .size(200.dp, 50.dp)
                    .clickable {
                        navController.navigate(Screen.DataScreen.route)
                    }
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "CONTINUAR")
            }
        }
    }
}

@Composable
fun TopOrderBar(navController: NavController) {
    var location by remember {
        mutableStateOf("tienda")
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black)
                .padding(15.dp)
                .clickable {
                    location = "casa"
                    loc = "casa"
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (location == "casa") {
                Text("CASA", color = Color.Black)
                Image(painter = painterResource(id = R.drawable.ic_home), contentDescription = null)
            } else {
                Text("CASA", color = Color.Gray)
                Image(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = null,
                    alpha = 0.5f
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black)
                .padding(15.dp)
                .clickable {
                    location = "tienda"
                    loc = "tienda"
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (location == "tienda") {
                Text("TIENDA PASEO DEL BORN", color = Color.Black)
                Image(
                    painter = painterResource(id = R.drawable.ic_tienda),
                    contentDescription = null
                )
            } else {
                Text("TIENDA PASEO DEL BORN", color = Color.Gray)
                Image(
                    painter = painterResource(id = R.drawable.ic_tienda),
                    contentDescription = null,
                    alpha = 0.5f
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black)
                .padding(15.dp)
                .clickable {
                    location = "punto"
                    loc = "punto"
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (location == "punto") {
                Text("PUNTO ENTREGA", color = Color.Black)
                Image(
                    painter = painterResource(id = R.drawable.ic_punto_entrega),
                    contentDescription = null
                )
            } else {
                Text("PUNTO ENTREGA", color = Color.Gray)
                Image(
                    painter = painterResource(id = R.drawable.ic_punto_entrega),
                    contentDescription = null,
                    alpha = 0.5f
                )
            }
        }
    }
}