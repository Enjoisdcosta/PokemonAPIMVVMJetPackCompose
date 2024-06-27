package com.example.pokemonapimvvmjetpackcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pokemonapimvvmjetpackcompose.R

// Set of Material typography styles to start with

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_black, FontWeight.Medium),
)
val RobotoCondensed = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Light),
    Font(R.font.roboto_black, FontWeight.Normal),
)

val LemonMilk = FontFamily(
    Font(R.font.lemon_milk_bold,FontWeight.Bold),
    Font(R.font.lemon_milk_regular,FontWeight.Normal)
)

val Typography = androidx.compose.material.Typography(
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)