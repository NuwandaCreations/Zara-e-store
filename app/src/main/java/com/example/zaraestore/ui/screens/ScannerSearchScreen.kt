package com.example.zaraestore.ui.screens

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.zaraestore.Screen
import com.example.zaraestore.model.Wear.Companion.boxers
import com.example.zaraestore.model.Wear.Companion.chaleco
import com.example.zaraestore.model.Wear.Companion.clothe
import com.example.zaraestore.model.Wear.Companion.sandalias
import com.example.zaraestore.model.Wear.Companion.shorts
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.CompoundBarcodeView

@Composable
fun ScannerSearchScreen(navController: NavController) {
    Column {
        val context = LocalContext.current
        var scanFlag by remember {
            mutableStateOf(false)
        }
        val compoundBarcodeView = remember {
            CompoundBarcodeView(context).apply {
                val capture = CaptureManager(context as Activity, this)
                capture.initializeFromIntent(context.intent, null)
                this.setStatusText("")
                this.resume()
                capture.decode()
                this.decodeContinuous { result ->
                    if(scanFlag){
                        return@decodeContinuous
                    }
                    scanFlag = true
                    result.text?.let { barCodeOrQr->
                        when (result.text.toString()) {
                            boxers.barcode -> {
                                clothe = boxers
                                navController.navigate(Screen.DetailsScreen.route)
                            }
                            chaleco.barcode -> {
                                clothe = chaleco
                                navController.navigate(Screen.DetailsScreen.route)
                            }
                            sandalias.barcode -> {
                                clothe = sandalias
                                navController.navigate(Screen.DetailsScreen.route)
                            }
                            shorts.barcode -> {
                                clothe = shorts
                                navController.navigate(Screen.DetailsScreen.route)
                            }
                            else -> {
                                navController.navigate(Screen.ScannerSearchScreen.route)
                            }
                        }
                        scanFlag = false
                    }
                    this.pause()
                }
            }
        }

        AndroidView(
            modifier = Modifier,
            factory = { compoundBarcodeView },
        )
    }
}