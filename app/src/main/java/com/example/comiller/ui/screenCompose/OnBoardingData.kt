package com.example.comiller.ui.screenCompose

import androidx.compose.ui.graphics.Color
import com.example.comiller.ui.screenCompose.theme.ColorBlue

data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
    val backgroundColor:Color,
    val mainColor:Color = ColorBlue
)