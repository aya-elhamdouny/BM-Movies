package com.example.bmmovies.domain.entities.query

data class MovieListingQuery(
    var pageNumber: Int,
    val sortBy: String,
    val language: String = "en-US",
)
