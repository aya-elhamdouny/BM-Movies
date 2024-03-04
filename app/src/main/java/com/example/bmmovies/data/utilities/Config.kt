package com.example.bmmovies.data.utilities

object Config {

    const val BASE_URL = "https://api.themoviedb.org/3/"

    const val ID = "id"
    const val PATH_ID = "{$ID}"

    const val DISCOVER_MOVIES_LISTING="discover/movie"
    const val MOVIE_DETAILS = "movie/$PATH_ID"
}