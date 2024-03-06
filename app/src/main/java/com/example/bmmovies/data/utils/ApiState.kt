package com.example.bmmovies.data.utils

sealed class ApiState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : ApiState<T>(data)
    class Error<T>(message: String, data: T? = null) : ApiState<T>(data, message)
}