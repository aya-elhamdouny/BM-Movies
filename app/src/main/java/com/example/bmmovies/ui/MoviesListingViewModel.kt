package com.example.bmmovies.ui

import Resource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmmovies.data.repository.MoviesRepository
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.MovieDetails
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import com.example.bmmovies.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListingViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    private var _moviesListState = MutableStateFlow(MoviesListState())
    val moviesListState = _moviesListState.asStateFlow()

    init {
        getMoviesList()
    }

    fun getMoviesList() {
        viewModelScope.launch {
            _moviesListState.update {
                it.copy(isLoading = true)
            }

            moviesRepository.getMoviesList(
                MovieListingQuery(moviesListState.value.moviesListPage, Constants.NOW_PLAYING_KEY)
            ).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _moviesListState.update {
                            it.copy(isLoading = false, isError = true)
                        }
                    }

                    is Resource.Loading -> {
                        _moviesListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { moviesList ->
                            _moviesListState.update {
                                it.copy(
                                    movieList = moviesListState.value.movieList + moviesList.data,
                                    moviesListPage = moviesListState.value.moviesListPage + 1
                                )
                            }
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}