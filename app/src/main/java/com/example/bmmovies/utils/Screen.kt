package com.example.bmmovies.utils

sealed class Screen(val route: String) {
    object BottomNavScreen : Screen("main")
    object MovieDetails : Screen("details")
}
