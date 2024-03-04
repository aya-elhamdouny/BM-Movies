package com.example.bmmovies.data.source.remote

import com.example.bmmovies.data.api.MoviesApi
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(private val moviesApi: MoviesApi) :
    MoviesRemoteSource {

}
