package com.example.bmmovies.domain.entities.quiries


data class MovieDetailsQuery(
    var movieId: Long,
    val language: String = "en-US",
    val appendToResponse: String = "videos",
    var apiKey: String = ""
)
