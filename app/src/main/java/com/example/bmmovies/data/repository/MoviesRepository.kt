package com.example.bmmovies.data.repository

import Resource
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.MovieDetails
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getMoviesList(movieListingQuery: MovieListingQuery): Flow<Resource<ResponsePagingResultModel<Movie>>>
    suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): Flow<Resource<MovieDetails>>
}
