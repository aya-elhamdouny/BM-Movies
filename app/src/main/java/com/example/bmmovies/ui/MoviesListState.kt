package com.example.bmmovies.ui

import com.example.bmmovies.domain.entities.local.Movie

data class MoviesListState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val listQuery: String = "",
    val moviesListPage: Int = 1,
    val movieList: List<Movie> = emptyList()
)