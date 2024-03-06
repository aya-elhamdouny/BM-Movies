package com.example.bmmovies.data.repository

import com.example.bmmovies.data.source.remote.MoviesRemoteSource
import com.example.bmmovies.data.utils.ApiState
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
    override suspend fun getMoviesList(movieListingQuery: MovieListingQuery): Flow<ApiState<ResponsePagingResultModel<Movie>>> {
        return flow {
            val response = try {
                moviesRemoteSource.getMoviesList(movieListingQuery)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(ApiState.Error(message = "IOException => ${e.message}"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(ApiState.Error(message = "HttpException => ${e.message()}"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiState.Error(message = "Exception => ${e.message}"))
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
            emit(ApiState.Success(moviesListResponse))
            return@flow
        }
    }


    override suspend fun getMovieDetails(movieDetailsQuery: MovieDetailsQuery): Flow<ApiState<MovieDetails>> {
        return flow {
            val response = try {
                moviesRemoteSource.getMovieDetails(movieDetailsQuery)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(ApiState.Error(message = "IOException => ${e.message}"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(ApiState.Error(message = "HttpException => ${e.message()}"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiState.Error(message = "Exception => ${e.message}"))
                return@flow
            }

            val movieDetails = movieDetailMapper.convert(response)

            emit(ApiState.Success(movieDetails))
            return@flow
        }
    }

}
