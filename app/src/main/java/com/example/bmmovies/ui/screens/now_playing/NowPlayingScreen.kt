package com.example.bmmovies.ui.screens.now_playing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.bmmovies.ui.MoviesListingViewModel
import com.example.bmmovies.ui.components.LoadingComponent
import com.example.bmmovies.ui.components.MovieListItem
import com.example.bmmovies.utils.Constants
import com.example.bmmovies.utils.ScreenState


@Composable
fun NowPlayingScreen() {
    val movieListViewModel = hiltViewModel<MoviesListingViewModel>()
    val screenState = movieListViewModel.screenState.collectAsState().value
    val navController = rememberNavController()

    movieListViewModel.setListQuery(Constants.NOW_PLAYING_KEY)

    when (screenState) {
        is ScreenState.Loading -> {
            LoadingComponent()
        }

        is ScreenState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = screenState.message)
            }
        }

        is ScreenState.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
            ) {
                screenState.data?.let { data ->
                    items(data.dataList.size) { index ->
                        MovieListItem(
                            movie = data.dataList[index],
                            navController = navController
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        if (index >= data.dataList.size - 1) {
//                            LoadMoreComponent()
//                            movieListViewModel.getNextPage()
                        }
                    }
                }
            }
        }
    }
}