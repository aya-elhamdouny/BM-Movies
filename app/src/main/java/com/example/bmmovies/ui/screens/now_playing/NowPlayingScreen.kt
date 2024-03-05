package com.example.bmmovies.ui.screens.now_playing

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.bmmovies.ui.MoviesListingViewModel
import com.example.bmmovies.ui.components.MovieListItem


@Composable
fun NowPlayingScreen(
    navController: NavController,
    viewModel: MoviesListingViewModel = hiltViewModel()
) {
    val lazyMovieItems = remember {
        viewModel.movieList
    }.collectAsLazyPagingItems()

    val listState = rememberLazyListState()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = "Movie App") }
            )
        }
    ) {
        if (lazyMovieItems.loadState.refresh is LoadState.Error) {
            ErrorView { lazyMovieItems.retry() }
        }
        LazyColumn(state = listState) {
            if (lazyMovieItems.loadState.refresh is LoadState.Loading) {
                items(10) {
                    LoadingShimmerEffect()
                }
            }
            items(lazyMovieItems.itemCount) { index ->
                lazyMovieItems[index]?.let { movie ->
                    MovieListItem(navController = navController, movie)
                }
            }
        }
    }
}