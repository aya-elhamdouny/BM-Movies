package com.example.bmmovies.data.api

import com.example.bmmovies.data.utils.Config
import com.example.bmmovies.domain.entities.remote.RemoteMovieDetails
import com.example.bmmovies.domain.entities.response.MoviesListingRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET(Config.DISCOVER_MOVIES_LISTING)
    suspend fun getDiscoverMoviesListing(
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String,
        @Query("language") language: String
    ): MoviesListingRemoteResponse

    @GET(Config.MOVIE_DETAILS)
    suspend fun getMovieDetails(
        @Path(Config.ID) movieId: Long,
        @Query("language") language: String,
        @Query("append_to_response") appendToResponse: String
    ): RemoteMovieDetails

}