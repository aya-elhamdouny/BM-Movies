package com.example.bmmovies.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.bmmovies.ui.screens.bottom_nav.BottomNavScreen
import com.example.bmmovies.ui.screens.movie_details.MovieDetailsScreen
import com.example.bmmovies.ui.theme.MovieAppTheme
import com.example.bmmovies.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MovieAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.BottomNavScreen.route
                ) {
                    composable(Screen.BottomNavScreen.route) {
                        BottomNavScreen(navController)
                    }

                    composable(
                        Screen.MovieDetails.route + "/{movieId}",
                        arguments = listOf(
                            navArgument("movieId") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        MovieDetailsScreen(navController)
                    }
                }
            }
        }
    }
}