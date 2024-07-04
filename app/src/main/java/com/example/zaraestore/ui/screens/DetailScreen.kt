package com.example.zaraestore.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import com.example.zaraestore.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zaraestore.Screen
import com.example.zaraestore.model.Clothes
import com.example.zaraestore.model.Wear.Companion.chaleco
import com.example.zaraestore.model.Wear.Companion.sandalias

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, wear: Clothes) {
    var bottomSheetState by remember { mutableIntStateOf(0) }
    var currentPosition by remember { mutableIntStateOf(1) }
    var boxColor =
        mutableListOf(Color.Gray, Color.Gray, Color.Gray, Color.Gray, Color.Gray, Color.Gray)
    var colorSize by remember { mutableStateOf(boxColor) }

    val imageSource = when (currentPosition % 2) {
        0 -> wear.image2
        else -> wear.image1
    }
    var valueInput by rememberSaveable { mutableStateOf("") }

    Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = imageSource),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    currentPosition++
                }
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(1f)) {
            Column(
                horizontalAlignment = Alignment.Start, modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxWidth()
                    .padding(start = 30.dp)
            ) {
                Spacer(modifier = Modifier.size(30.dp))
                Text(text = wear.name, fontSize = 20.sp)
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = wear.price)
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = wear.description)
                Spacer(modifier = Modifier.size(50.dp))
//                Text(text = "VER DISPONIBILIDAD EN TIENDA", Modifier.clickable {
//                    bottomSheetState = true
//                })
//                Spacer(modifier = Modifier.size(30.dp))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.size(30.dp))
                Text(text = "SELECCIONA UNA TALLA")
                Spacer(modifier = Modifier.size(20.dp))
                Row {
                    Spacer(modifier = Modifier.size(25.dp))
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black)
                            .size(120.dp, 40.dp)
                            .clickable { bottomSheetState = 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        if (wear == sandalias) {
                            Text(text = "35")
                        } else {
                            Text(text = "XS")
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black)
                            .size(120.dp, 40.dp)
                            .clickable { bottomSheetState = 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        if (wear == sandalias) {
                            Text(text = "36")
                        } else {
                            Text(text = "S")
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black)
                            .size(120.dp, 40.dp)
                            .clickable { bottomSheetState = 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        if (wear == sandalias) {
                            Text(text = "37")
                        } else {
                            Text(text = "M")
                        }
                    }
                    Spacer(modifier = Modifier.size(25.dp))
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row {
                    Spacer(modifier = Modifier.size(25.dp))
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black)
                            .size(120.dp, 40.dp)
                            .clickable { bottomSheetState = 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        if (wear == sandalias) {
                            Text(text = "38")
                        } else {
                            Text(text = "L")
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black)
                            .size(120.dp, 40.dp)
                            .clickable { bottomSheetState = 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        if (wear == sandalias) {
                            Text(text = "39")
                        } else {
                            Text(text = "XL")
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black)
                            .size(120.dp, 40.dp)
                            .clickable { bottomSheetState = 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        if (wear == sandalias) {
                            Text(text = "40")
                        } else {
                            Text(text = "XXL")
                        }
                    }
                    Spacer(modifier = Modifier.size(25.dp))
                }
                Spacer(modifier = Modifier.size(30.dp))
            }

//            Box(
//                modifier = Modifier
//                    .border(width = 1.dp, color = Color.Black)
//                    .fillMaxWidth()
//                    .padding(vertical = 20.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "AÑADIR", modifier = Modifier.clickable { })
//            }
        }
//        Spacer(modifier = Modifier.size(40.dp))
        if (bottomSheetState == 1) {
            ModalBottomSheet(
                onDismissRequest = { bottomSheetState = 0 },
                modifier = Modifier.fillMaxWidth()
            ) {
                if (wear == chaleco) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 50.dp, end = 50.dp, bottom = 15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "ARTÍCULO EN TIENDA")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "El artículo seleccionado se encuentra en:")
                        Spacer(modifier = Modifier.size(20.dp))
                        Column(modifier = Modifier.border(width = 1.dp, color = Color.Black)) {
                            Column(
                                modifier = Modifier
//                                    .border(width = 1.dp, color = Color.Black)
                                    .padding(start = 7.dp)
                            ) {
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(text = "PLANTA 1")
                                Spacer(modifier = Modifier.size(7.dp))
                                Text(text = "Mujer")
                                Spacer(modifier = Modifier.size(10.dp))
                            }
                            Image(
                                painter = painterResource(id = R.drawable.ic_planta1),
                                contentDescription = null
                            )
                        }
                    }
                }

                if (wear == sandalias) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 50.dp, end = 50.dp, bottom = 15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "ARTÍCULO EN TIENDA")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "La talla seleccionada se encuentra en el almacén")
                        Spacer(modifier = Modifier.size(20.dp))
                        Row {
                            Box(modifier = Modifier
                                .border(width = 1.dp, color = Color.Black)
                                .padding(7.dp)
                                .clickable {
                                    bottomSheetState = 2
                                }) {
                                Text(text = "Solicitar artículo")
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                            Box(modifier = Modifier
                                .border(width = 1.dp, color = Color.Black)
                                .padding(7.dp)
                                .clickable { navController.navigate(Screen.HomeScreen.route) }) {
                                Text(text = "Cancelar")
                            }
                        }

                    }
                }


//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 50.dp, end = 50.dp, bottom = 15.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(text = "VER DISPONIBILIDAD EN TIENDA PASEO DEL BORNE")
//                    Spacer(modifier = Modifier.size(20.dp))
//                    Text(text = "Selecciona una o más tallas para comprobar su disponibilidad en tiendas")
//                    Spacer(modifier = Modifier.size(20.dp))
//                    Text(text = "¿Qué talla buscas?")
//                    Spacer(modifier = Modifier.size(20.dp))
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        Spacer(modifier = Modifier.size(25.dp))
//                        Box(
//                            modifier = Modifier
//                                .border(width = 1.dp, color = colorSize[0])
//                                .size(100.dp, 30.dp)
//                                .clickable {
//                                    colorSize[0] = Color.Black
//                                }, contentAlignment = Alignment.Center
//                        ) {
//                            Text(text = "XS", color = colorSize[0])
//                        }
//                        Spacer(modifier = Modifier.size(20.dp))
//                        Box(
//                            modifier = Modifier
//                                .border(width = 1.dp, color = colorSize[1])
//                                .size(100.dp, 30.dp)
//                                .clickable {
//                                    colorSize[1] = Color.Black
//                                }, contentAlignment = Alignment.Center
//                        ) {
//                            Text(text = "S", color = colorSize[1])
//                        }
//                        Spacer(modifier = Modifier.size(20.dp))
//                        Box(
//                            modifier = Modifier
//                                .border(width = 1.dp, color = colorSize[2])
//                                .size(100.dp, 30.dp)
//                                .clickable {
//                                    colorSize[2] = Color.Black
//                                }, contentAlignment = Alignment.Center
//                        ) {
//                            Text(text = "M", color = colorSize[2])
//                        }
//                        Spacer(modifier = Modifier.size(20.dp))
//                        Box(
//                            modifier = Modifier
//                                .border(width = 1.dp, color = colorSize[3])
//                                .size(100.dp, 30.dp)
//                                .clickable {
//                                    colorSize[3] = Color.Black
//                                }, contentAlignment = Alignment.Center
//                        ) {
//                            Text(text = "L", color = colorSize[3])
//                        }
//                        Spacer(modifier = Modifier.size(20.dp))
//                        Box(
//                            modifier = Modifier
//                                .border(width = 1.dp, color = colorSize[4])
//                                .size(100.dp, 30.dp)
//                                .clickable {
//                                    colorSize[4] = Color.Black
//                                }, contentAlignment = Alignment.Center
//                        ) {
//                            Text(text = "XL", color = colorSize[4])
//                        }
//                        Spacer(modifier = Modifier.size(20.dp))
//                        Box(
//                            modifier = Modifier
//                                .border(width = 1.dp, color = colorSize[5])
//                                .size(100.dp, 30.dp)
//                                .clickable {
//                                    colorSize[5] = Color.Black
//                                }, contentAlignment = Alignment.Center
//                        ) {
//                            Text(text = "XXL", color = colorSize[5])
//                        }
//                        Spacer(modifier = Modifier.size(75.dp))
//                    }
//                    Box(
//                        modifier = Modifier
//                            .border(width = 1.dp, color = Color.Black)
//                            .fillMaxWidth()
//                            .padding(vertical = 20.dp, horizontal = 100.dp)
//                            .clickable {
//
//                            },
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = "VER DISPONIBILIDAD")
//                    }
//                }
            }
        }
        if (bottomSheetState == 2) {
            ModalBottomSheet(
                onDismissRequest = { bottomSheetState = 0 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 15.dp,
                        top = 15.dp
                    ).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Introduce tu número de teléfono y te avisaremos cuando esté lista en el punto de recogida")
                    Spacer(modifier = Modifier.size(20.dp))
                    OutlinedTextField(
                        value = valueInput,
                        onValueChange = {
                            valueInput = it
                        })
                    Spacer(modifier = Modifier.size(20.dp))
                    Box(modifier = Modifier
                        .border(width = 1.dp, color = Color.Black)
                        .padding(7.dp)
                        .clickable { navController.navigate(Screen.HomeScreen.route) }) {
                        Text(text = "Enviar petición")
                    }
                }
            }
        }
    }
}