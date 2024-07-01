package com.example.zaraestore.screens

import android.app.Activity
import android.util.Log
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
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.CompoundBarcodeView

@Composable
fun SearchScreen(navController: NavController) {
    ReferenceSearchScreen(navController)
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
                    Log.i("escaneo", result.text)
                    navController.navigate(Screen.HomeScreen.route)
                }
                scanFlag = false
            }
//            val intentIntegrator = IntentIntegrator(context as Activity)
//            intentIntegrator.initiateScan()
//            this.resume()
//            this.decodeContinuous { result ->
//                Log.i("escaneo", "result.text")
//                result.text?.let { barCodeOrQr ->
//                    //Do something and when you finish this something
//                    //put scanFlag = false to scan another item
//                    navController.navigate(Screen.HomeScreen.route)
//                }
//            }

        }
    }

    AndroidView(
        modifier = Modifier,
        factory = { compoundBarcodeView },
    )

}