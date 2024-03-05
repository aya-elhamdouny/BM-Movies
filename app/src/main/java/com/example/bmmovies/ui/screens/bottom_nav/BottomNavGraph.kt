package com.example.bmmovies.ui.screens.bottom_nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bmmovies.ui.screens.now_playing.NowPlayingScreen
import com.example.bmmovies.ui.screens.popular.PopularScreen
import com.example.bmmovies.ui.screens.upcoming.UpComingScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreenItem.NowPlaying.route)
    {
        composable(BottomBarScreenItem.NowPlaying.route) {
            NowPlayingScreen()
        }
        composable(BottomBarScreenItem.Popular.route) {
            PopularScreen()
        }
        composable(BottomBarScreenItem.UpComing.route) {
            UpComingScreen()
        }
    }
}
