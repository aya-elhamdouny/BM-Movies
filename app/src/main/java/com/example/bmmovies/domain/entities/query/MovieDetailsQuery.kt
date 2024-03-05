package com.example.bmmovies.domain.entities.query


data class MovieDetailsQuery(
    var movieId: Long,
    val language: String = "en-US",
    val appendToResponse: String = "videos",
//    var apiKey: String = "95f7a492542e065f89ea88ff37aa8122"
)
