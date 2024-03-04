package com.example.bmmovies.di
import com.example.bmmovies.data.repository.MoviesRepository
import com.example.bmmovies.data.repository.MoviesRepositoryImpl
import com.example.bmmovies.data.source.remote.MoviesRemoteSource
import com.example.bmmovies.data.source.remote.MoviesRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindMoviesListingRepository(
        moviesListingRepositoryImpl: MoviesRepositoryImpl
    ): MoviesRepository

    @Binds
    abstract fun bindMoviesListingRemoteSource(
        moviesListingRemoteSourceImpl: MoviesRemoteSourceImpl
    ): MoviesRemoteSource
}