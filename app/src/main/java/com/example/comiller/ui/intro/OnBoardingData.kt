package com.example.comiller.ui.intro

import androidx.compose.ui.graphics.Color
import com.example.comiller.ui.intro.theme.ColorBlue

data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
    val backgroundColor:Color,
    val mainColor:Color = ColorBlue
)