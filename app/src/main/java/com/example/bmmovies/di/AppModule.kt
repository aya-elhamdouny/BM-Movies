package com.example.bmmovies.di
import com.example.bmmovies.data.data.repository.MoviesRepository
import com.example.bmmovies.data.data.repository.MoviesRepositoryImpl
import com.example.bmmovies.data.source.remote.MoviesRemoteSource
import com.example.bmmovies.data.source.remote.MoviesRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Binds
    abstract fun bindMoviesListingRepository(
        moviesListingRepositoryImpl: MoviesRepositoryImpl
    ): MoviesRepository

    @Binds
    abstract fun bindMoviesListingRemoteSource(
        moviesListingRemoteSourceImpl: MoviesRemoteSourceImpl
    ): MoviesRemoteSource






}