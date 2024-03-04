package com.example.bmmovies.domain.entities.quiries

data class MovieListingQuery(
    var pageNumber: Int,
    val sortBy: String = "popularity.desc",
    val language: String = "en-US",
    var apiKey: String=""
)
