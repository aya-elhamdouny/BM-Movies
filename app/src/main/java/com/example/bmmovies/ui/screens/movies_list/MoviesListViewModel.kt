package com.example.bmmovies.ui.screens.movies_list

import android.util.Log
import com.example.bmmovies.utils.ScreenState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmmovies.data.repository.MoviesRepository
import com.example.bmmovies.data.utils.ApiState
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private var _screenState =
        MutableStateFlow<ScreenState<ResponsePagingResultModel<Movie>>>(ScreenState.Loading())
    val screenState = _screenState.asStateFlow()

    private var dataList = emptyList<Movie>()
    private var currentPage = 1
    private var listQuery = ""

    fun setListQuery(query: String) {
        listQuery = query
        getMoviesList()
    }

    private fun getMoviesList() {
        viewModelScope.launch {
            moviesRepository.getMoviesList(
                MovieListingQuery(currentPage, listQuery)
            ).catch { error ->
                val errorMessage = error.message ?: "Somthing wrong happened"
                _screenState.value = ScreenState.Error(message = errorMessage)
                return@catch
            }.collectLatest { result ->
                when (result) {
                    is ApiState.Error -> {
                        val errorMessage = result.message ?: "Network error happened"
                        _screenState.value = ScreenState.Error(message = errorMessage)
                    }

                    is ApiState.Success -> {
                        result.data?.let { data ->
                            dataList = dataList + data.dataList
                            _screenState.value = ScreenState.Success(data)
                        }
                    }
                }
                return@collectLatest
            }
        }
    }

    fun getNextPage() {
        currentPage += 1
        getMoviesList()
    }
}