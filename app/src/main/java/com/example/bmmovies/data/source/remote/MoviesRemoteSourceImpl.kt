package com.example.bmmovies.data.source.remote

import com.example.bmmovies.data.api.MoviesApi
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import com.example.bmmovies.domain.entities.remote.RemoteMovieDetails
import com.example.bmmovies.domain.entities.response.MoviesListingRemoteResponse
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(private val moviesApi: MoviesApi) :
    MoviesRemoteSource {
    override suspend fun getMoviesList(movieListingQuery: MovieListingQuery): MoviesListingRemoteResponse {
        return moviesApi.getDiscoverMoviesListing(
            movieListingQuery.sortBy,
            movieListingQuery.pageNumber,
        )
    }

    override suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): RemoteMovieDetails {
        return moviesApi.getMovieDetails(
            movieDetailsQuery.movieId,
            movieDetailsQuery.language,
            movieDetailsQuery.appendToResponse
        )
    }
}
