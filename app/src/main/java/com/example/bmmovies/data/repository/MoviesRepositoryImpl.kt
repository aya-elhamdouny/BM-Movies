package com.example.bmmovies.data.repository

import com.example.bmmovies.data.source.remote.MoviesRemoteSource
import com.example.bmmovies.domain.entities.quiries.MovieDetailsQuery
import com.example.bmmovies.domain.entities.quiries.MovieListingQuery
import com.example.bmmovies.domain.entities.remote.RemoteMovieDetails
import com.example.bmmovies.domain.entities.response.MoviesListingRemoteResponse
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesRemoteSource: MoviesRemoteSource) :
    MoviesRepository {
    override suspend fun getMoviesList(movieListingQuery: MovieListingQuery): MoviesListingRemoteResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): RemoteMovieDetails {
        TODO("Not yet implemented")
    }

}
