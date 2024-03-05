package com.example.bmmovies.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmmovies.data.repository.MoviesRepository
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.MovieDetails
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListingViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val popularMoviesList = MutableLiveData<ResponsePagingResultModel<Movie>>()
    private val nowPlayingMoviesList = MutableLiveData<ResponsePagingResultModel<Movie>>()
    private val upcomingMoviesList = MutableLiveData<ResponsePagingResultModel<Movie>>()


    val movieList: Flow<ResponsePagingResultModel<Movie>> get() = getMovies()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getUpcomingMoviesData()
        }
    }

    private fun getMovies() = moviesRepository.getMoviesList(MovieListingQuery(1, "upcoming"))


    public suspend fun getUpcomingMoviesData(): ResponsePagingResultModel<Movie> {
        return moviesRepository.getMoviesList(MovieListingQuery(1, "upcoming"))

    }

    public suspend fun getNowPlayingMoviesData(): ResponsePagingResultModel<Movie> {
        return moviesRepository.getMoviesList(MovieListingQuery(1, "now_playing"))

    }

    public suspend fun getPopularMoviesMoviesData(): ResponsePagingResultModel<Movie> {
        return moviesRepository.getMoviesList(MovieListingQuery(1, "popular"))

    }

    public suspend fun getDetailData(): MovieDetails {
        return moviesRepository.getMovieDetails(MovieDetailsQuery(322))

    }
}