package com.example.bmmovies.ui.screens.movies_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bmmovies.utils.components.LoadingComponent
import com.example.bmmovies.ui.screens.movies_list.components.MovieListItem
import com.example.bmmovies.utils.ScreenState
import com.example.bmmovies.utils.components.ErrorView


@Composable
fun MoviesListScreen(
    listQuery: String, navController: NavHostController,
) {
    val movieListViewModel = hiltViewModel<MoviesListViewModel>(key = listQuery)

    LaunchedEffect(Unit) {
        movieListViewModel.setListQuery(listQuery)
    }

    when (val screenState = movieListViewModel.screenState.collectAsState().value) {
        is ScreenState.Loading -> {
            LoadingComponent()
        }

        is ScreenState.Error -> {
            ErrorView(screenState.message) {
                movieListViewModel.getMoviesList()
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
//                            LaunchedEffect(Unit) {
//                                movieListViewModel.getNextPage()
//                            }
                        }
                    }
                }
            }
        }
    }
}