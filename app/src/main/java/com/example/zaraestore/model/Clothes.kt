package com.example.zaraestore.model

data class Clothes(
    val barcode: String,
    var image1: Int,
    var image2: Int,
    val name: String,
    val description: String,
    val price: String,
    val location: String,
    val sizeXS: Boolean = false,
    val sizeS: Boolean = false,
    val sizeM: Boolean = false,
    val sizeL: Boolean = false,
    val sizeXL: Boolean = false,
    val sizeXXL: Boolean = false,
)
