package com.example.bmmovies.domain.entities.local

data class Movie(
    val id:Long=0,
    val title:String="",
    val posterImage:String="",
    val releaseDate:String="",
    val rating:Float=0.0f,
    val overview:String=""
)
data class ResponsePagingResultModel<T>(
    val data: List<T>,
    val totalResults: Int,
    val totalPages: Int
)