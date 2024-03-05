package com.example.bmmovies.data.repository

import Resource
import com.example.bmmovies.data.source.remote.MoviesRemoteSource
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.local.MovieDetails
import com.example.bmmovies.domain.entities.local.ResponsePagingResultModel
import com.example.bmmovies.domain.mapper.MovieDetailsMapper
import com.example.bmmovies.domain.mapper.MovieMapper
import com.example.bmmovies.domain.entities.query.MovieDetailsQuery
import com.example.bmmovies.domain.entities.query.MovieListingQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteSource: MoviesRemoteSource,
    private val movieMapper: MovieMapper,
    private val movieDetailMapper: MovieDetailsMapper
) : MoviesRepository {
    override suspend fun getMoviesList(movieListingQuery: MovieListingQuery): Flow<Resource<ResponsePagingResultModel<Movie>>> {
        return flow {
            emit(Resource.Loading(true))

            val response = try {
                moviesRemoteSource.getMoviesList(movieListingQuery)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "IOException => ${e.message}"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "HttpException => ${e.message()}"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Exception => ${e.message}"))
                return@flow
            }

            val mappedList = response.results?.map {
                movieMapper.convert(it)
            } ?: listOf()
            val moviesListResponse = ResponsePagingResultModel(
                mappedList,
                response.totalResults ?: 0,
                response.totalPages ?: 0
            )

            emit(Resource.Success(moviesListResponse))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): Flow<Resource<MovieDetails>> {
        return flow {
            emit(Resource.Loading(true))

            val response = try {
                moviesRemoteSource.getMovieDetails(movieDetailsQuery)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "IOException => ${e.message}"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "HttpException => ${e.message()}"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Exception => ${e.message}"))
                return@flow
            }

            val movieDetails = movieDetailMapper.convert(response)

            emit(Resource.Success(movieDetails))
            emit(Resource.Loading(false))
        }
    }

}
