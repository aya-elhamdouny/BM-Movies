package com.example.bmmovies.ui.screens.now_playing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bmmovies.ui.MoviesListingViewModel
import com.example.bmmovies.ui.components.MovieListItem


@Composable
fun NowPlayingScreen() {
    val movieListViewModel = hiltViewModel<MoviesListingViewModel>()
    val movieListState = movieListViewModel.nowPlayingMoviesListState.collectAsState().value
    val navController = rememberNavController()

    if (movieListState.movieList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
        ) {
            items(movieListState.movieList.size) { index ->
                MovieListItem(
                    movie = movieListState.movieList[index],
                    navController = navController
                )

                Spacer(modifier = Modifier.height(16.dp))

                if (index >= movieListState.movieList.size - 1 && !movieListState.isLoading) {
                    movieListViewModel.getNowPlayingMoviesList()
                }
            }
        }
    }

}