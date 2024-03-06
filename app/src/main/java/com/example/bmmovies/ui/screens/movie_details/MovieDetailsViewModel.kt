package com.example.bmmovies.ui.screens.movie_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmmovies.data.repository.MoviesRepository
import com.example.bmmovies.data.utils.ApiState
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.MovieDetails
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import com.example.bmmovies.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val movieId = savedStateHandle.get<Int>("movieId") ?: -1
    private var _screenState =
        MutableStateFlow<ScreenState<MovieDetails>>(ScreenState.Loading())
    val screenState = _screenState.asStateFlow()

    private var movieDetails = MovieDetails()

    init {
        getMovieDetails()
    }

     fun getMovieDetails() {
        viewModelScope.launch {
            moviesRepository.getMovieDetails(MovieDetailsQuery(movieId = movieId))
                .catch { error ->
                    val errorMessage = error.message ?: "Somthing wrong happened"
                    _screenState.value = ScreenState.Error(message = errorMessage)
                    return@catch
                }
                .collectLatest { result ->
                    when (result) {
                        is ApiState.Error -> {
                            val errorMessage = result.message ?: "Network error happened"
                            _screenState.value = ScreenState.Error(message = errorMessage)
                        }

                        is ApiState.Success -> {
                            result.data?.let { data ->

                                movieDetails = data
                                _screenState.value = ScreenState.Success(data)
                            }
                        }
                    }
                    return@collectLatest
                }
        }
    }
}