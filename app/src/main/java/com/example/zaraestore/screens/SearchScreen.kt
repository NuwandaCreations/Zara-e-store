package com.example.zaraestore.screens

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.zaraestore.MainActivity
import com.example.zaraestore.Screen
import com.example.zaraestore.ZaraEstoreApp.Companion.appContext
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.CompoundBarcodeView

@Composable
fun SearchScreen(navController: NavController) {
    ReferenceSearchScreen(navController)
    val context = LocalContext.current
//    CompoundBarcodeView(context).apply {
//        val capture = CaptureManager(context as Activity, this)
////        capture.initializeFromIntent((appContext as Activity).intent, null)
////        this.setStatusText("")
////        capture.decode()
//    }

    val compoundBarcodeView = remember {
        CompoundBarcodeView(context).apply {
            val intentIntegrator = IntentIntegrator(context as Activity)
            intentIntegrator.initiateScan()
            this.resume()
        }
    }
    // Register the launcher and result handler
//    val barcodeLauncher = ScanContract()
//// Launch
//    barcodeLauncher.launch(ScanOptions())
//        barcodeLauncher.launch(new ScanOptions());


//    val compoundBarcodeView = remember {
//        CompoundBarcodeView(context).apply {
//            val capture = CaptureManager(context as Activity, this)
//            capture.initializeFromIntent(context.intent, null)
//            this.setStatusText("")
//            capture.decode()
////            this.resume()
//            this.decodeContinuous { result ->
////                if(scanFlag){
////                    return@decodeContinuous
////                }
////                scanFlag = true
////                result.text?.let { barCodeOrQr->
////                    //Do something and when you finish this something
////                    //put scanFlag = false to scan another item
////                    scanFlag = false
////                }
//                //If you don't put this scanFlag = false, it will never work again.
//                //you can put a delay over 2 seconds and then scanFlag = false to prevent multiple scanning
//
//            }
//        }
//    }
//
    AndroidView(
        modifier = Modifier,
        factory = { compoundBarcodeView },
    )

}