package com.example.bmmovies.ui.screens.upcoming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun UpComingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
    ) {
        Text(text = "UpComingScreen", color = Color.White)
    }
}