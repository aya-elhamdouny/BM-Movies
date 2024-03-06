package com.example.bmmovies.ui.screens.bottom_nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.bmmovies.ui.screens.movie_details.MovieDetailsScreen
import com.example.bmmovies.ui.screens.movies_list.MoviesListScreen
import com.example.bmmovies.utils.Constants
import com.example.bmmovies.utils.Screen

@ExperimentalCoilApi
@Composable
fun BottomNavGraph(bottomNavHostController: NavHostController, navController: NavHostController) {
    NavHost(navController = bottomNavHostController, startDestination = BottomBarScreenItem.NowPlaying.route)
    {
        composable(BottomBarScreenItem.NowPlaying.route) {
            MoviesListScreen(Constants.NOW_PLAYING_KEY, navController)
        }
        composable(BottomBarScreenItem.Popular.route) {
            MoviesListScreen(Constants.POPULAR_KEY, navController)
        }
        composable(BottomBarScreenItem.UpComing.route) {
            MoviesListScreen(Constants.UPCOMING_KEY, navController)
        }
    }
}
