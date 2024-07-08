package com.example.zaraestore.model

import com.example.zaraestore.R

class Wear() {
    companion object {
        val boxers = Clothes(
            "03067423064023",
            R.drawable.ic_boxers1,
            R.drawable.ic_boxers2,
            "BÓXER ESTRELLAS X TWOJEYS LIMITED EDITION",
            "Calzoncillo tipo bóxer confeccionado en popelín. Cintura elástica.Colección especial TwoJeys x Zara.",
            "19,95 EUR",
            "Planta 2 Caballero",
            false,
            false,
            true,
            true,
            true,
            true,
        )

        val chaleco = Clothes(
            "04749709250014",
            R.drawable.ic_chaleco,
            R.drawable.ic_chaleco2,
            "CHALECO FRUNCES",
            "Chaleco de cuello redondo y manga sisa. Detalle de frunces ajustables con cordones en delantero. Cierre frontal con cremallera metálica.",
            "17,99 EUR",
            "Online",
            true,
            true,
            true,
            true,
            false,
            false,
        )

        val sandalias = Clothes(
            "11652310002388",
            R.drawable.ic_sandalias1,
            R.drawable.ic_sandalias2,
            "SANDALIA PLANA TIRAS",
            "Sandalia plana con tejido entrelazado. Doble tira. Detalle de abalorios de colores en diferentes tamaños con forma de piedra. Acabada en punta redonda.",
            "25,99 EUR",
            "Almacén",
            true,
            true,
            true,
            false,
            false,
            false,
        )

        val shorts = Clothes(
            "04442303712031",
            R.drawable.ic_shorts1,
            R.drawable.ic_shorts2,
            "SHORTS CUADRO VICHY",
            "Shorts de tiro medio y cintura elástica ajustable con lazada satinada. Bolsillos laterales.",
            "12,99 EUR",
            "No disponible",
            false,
            true,
            true,
            false,
            false,
            false,
        )

        lateinit var clothe: Clothes
        var loc = "tienda"
        var notification = "Nos pondremos en contacto"
        //STOCK EN LA TIENDA, EN EL ALMACEN, SOLO ONLINE, NINGUN STOCK
    }
}