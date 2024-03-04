package com.example.bmmovies.data.data.repository

import com.example.bmmovies.domain.entities.response.MoviesListingRemoteResponse
import com.example.bmmovies.domain.entities.remote.RemoteMovieDetails
import com.example.bmmovies.domain.entities.quiries.MovieDetailsQuery
import com.example.bmmovies.domain.entities.quiries.MovieListingQuery

interface MoviesRepository {

    suspend fun getMoviesList(movieListingQuery: MovieListingQuery): MoviesListingRemoteResponse
    suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): RemoteMovieDetails

}
