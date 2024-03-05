package com.example.bmmovies.domain.entities.local

data class ResponsePagingResultModel<T>(
    val data: List<T>,
    val totalResults: Int,
    val totalPages: Int
)