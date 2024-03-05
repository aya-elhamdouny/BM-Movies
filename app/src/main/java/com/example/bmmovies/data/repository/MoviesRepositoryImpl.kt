package com.example.bmmovies.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.bmmovies.data.source.remote.MoviesRemoteSource
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.MovieDetails
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.mapper.MovieDetailsMapper
import com.example.bmmovies.domain.mapper.MovieMapper
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor
    (private val moviesRemoteSource: MoviesRemoteSource,
     private val movieMapper : MovieMapper,
     private val movieDetailMapper : MovieDetailsMapper
) :
    MoviesRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getMoviesList(movieListingQuery: MovieListingQuery): ResponsePagingResultModel<Movie> {
         val dto = moviesRemoteSource.getMoviesList(movieListingQuery)
        val mappedList = dto.results?.map {
            movieMapper.convert(it)
        } ?: listOf()
        return ResponsePagingResultModel(
            mappedList,
            dto.totalResults ?: 0,
            dto.totalPages ?: 0
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): MovieDetails {
        val dto = moviesRemoteSource.getMovieDetails(movieDetailsQuery)
        return movieDetailMapper.convert(dto)

    }

}
