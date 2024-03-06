package com.example.bmmovies.domain.entities.query


data class MovieDetailsQuery(
    var movieId: Int,
    val language: String = "en-US",
    val appendToResponse: String = "videos",
)
