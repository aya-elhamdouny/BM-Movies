package com.example.bmmovies.ui

import Resource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmmovies.data.repository.MoviesRepository
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import com.example.bmmovies.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private var _popularMoviesListState = MutableStateFlow(MoviesListState())
     val popularMoviesListState = _popularMoviesListState.asStateFlow()

    private var _upComingMoviesListState = MutableStateFlow(MoviesListState())
     val upComingMoviesListState = _upComingMoviesListState.asStateFlow()


    private var _nowPlayingMoviesListState = MutableStateFlow(MoviesListState())
     val nowPlayingMoviesListState = _nowPlayingMoviesListState.asStateFlow()

    init {
        getPopularMoviesList()
        getupComingMoviesList()
        getNowPlayingMoviesList()
    }

     fun getPopularMoviesList() {
        viewModelScope.launch {
            _popularMoviesListState.update {
                it.copy(isLoading = true)
            }

            moviesRepository.getMoviesList(
                MovieListingQuery(popularMoviesListState.value.moviesListPage, Constants.POPULAR_KEY)
            ).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _popularMoviesListState.update {
                            it.copy(isLoading = false, isError = true)
                        }
                    }

                    is Resource.Loading -> {
                        _popularMoviesListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { moviesList ->
                            _popularMoviesListState.update {
                                it.copy(
                                    movieList = popularMoviesListState.value.movieList + moviesList.data,
                                    moviesListPage = popularMoviesListState.value.moviesListPage + 1
                                )
                            }
                        }
                    }

                    else -> {}
                }
            }
        }
    }
     fun getupComingMoviesList() {
        viewModelScope.launch {
            _upComingMoviesListState.update {
                it.copy(isLoading = true)
            }

            moviesRepository.getMoviesList(
                MovieListingQuery(upComingMoviesListState.value.moviesListPage, Constants.UPCOMING_KEY)
            ).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _upComingMoviesListState.update {
                            it.copy(isLoading = false, isError = true)
                        }
                    }

                    is Resource.Loading -> {
                        _upComingMoviesListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { moviesList ->
                            _upComingMoviesListState.update {
                                it.copy(
                                    movieList = upComingMoviesListState.value.movieList + moviesList.data,
                                    moviesListPage = upComingMoviesListState.value.moviesListPage + 1
                                )
                            }
                        }
                    }

                    else -> {}
                }
            }
        }
    }
     fun getNowPlayingMoviesList() {
        viewModelScope.launch {
            _nowPlayingMoviesListState.update {
                it.copy(isLoading = true)
            }

            moviesRepository.getMoviesList(
                MovieListingQuery(nowPlayingMoviesListState.value.moviesListPage, Constants.NOW_PLAYING_KEY)
            ).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _nowPlayingMoviesListState.update {
                            it.copy(isLoading = false, isError = true)
                        }
                    }

                    is Resource.Loading -> {
                        _nowPlayingMoviesListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { moviesList ->
                            _nowPlayingMoviesListState.update {
                                it.copy(
                                    movieList = nowPlayingMoviesListState.value.movieList + moviesList.data,
                                    moviesListPage = nowPlayingMoviesListState.value.moviesListPage + 1
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