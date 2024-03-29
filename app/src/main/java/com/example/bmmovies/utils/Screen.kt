package com.example.bmmovies.utils

sealed class Screen(val route: String) {
    object BottomNavScreen : Screen("bottomNavScreen")
    object MovieDetails : Screen("movieDetails")
}
