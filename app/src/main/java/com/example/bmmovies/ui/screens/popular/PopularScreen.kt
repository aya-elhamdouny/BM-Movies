package com.example.bmmovies.ui.screens.popular

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PopularScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
    ) {
        Text(text = "PopularScreen", color = Color.White)
    }
}