package com.example.bmmovies.ui.screens.bottom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreenItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Popular : BottomBarScreenItem(
        route = "popular",
        title = "Popular",
        icon = Icons.Default.Favorite
    )

    data object NowPlaying : BottomBarScreenItem(
        route = "now_playing",
        title = "Now Playing",
        icon = Icons.Default.PlayArrow
    )

    data object UpComing : BottomBarScreenItem(
        route = "upcoming",
        title = "Upcoming",
        icon = Icons.Default.Menu
    )
}