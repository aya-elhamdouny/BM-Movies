package com.example.bmmovies.domain.entities.query

data class MovieListingQuery(
    var pageNumber: Int,
    val sortBy: String ,
    val language: String = "en-US",
//    var apiKey: String="95f7a492542e065f89ea88ff37aa8122"
)
