package com.example.bmmovies.data.repository

import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.MovieDetails
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery

interface MoviesRepository {

    suspend fun getMoviesList(movieListingQuery: MovieListingQuery): ResponsePagingResultModel<Movie>
    suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): MovieDetails

}
