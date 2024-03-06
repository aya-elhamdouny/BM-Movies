package com.example.bmmovies.domain.entities.local

data class MovieDetails(
    val id: Int = 0,
    val title: String = "",
    val posterImage: String = "",
    val releaseDate: String = "",
    val rating: String = "",
    val overview: String = "",
    val backdropImage: String = "",
    val voteCount: String = "",
    val isAdult: String = "",
    val trailers: List<Trailer> = listOf()
)