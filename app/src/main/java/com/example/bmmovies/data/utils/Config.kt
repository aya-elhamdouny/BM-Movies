package com.example.bmmovies.data.utils

object Config {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val ID = "id"
    private const val PATH_ID = "{$ID}"
    const val MOVIES_LISTING = "movie/$PATH_ID"
    const val MOVIE_DETAILS = "movie/$PATH_ID"
}