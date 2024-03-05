package com.example.bmmovies.data.source.remote

import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import com.example.bmmovies.domain.entities.remote.RemoteMovieDetails
import com.example.bmmovies.domain.entities.response.MoviesListingRemoteResponse

interface MoviesRemoteSource {
    suspend fun getMoviesList(movieListingQuery: MovieListingQuery): MoviesListingRemoteResponse
    suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): RemoteMovieDetails
}
