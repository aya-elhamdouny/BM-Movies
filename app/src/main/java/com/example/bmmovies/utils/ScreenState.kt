package com.example.bmmovies.utils

sealed class ScreenState<T>(
    val data: T? = null,
    val message: String = ""
) {
    class Success<T>(data: T?) : ScreenState<T>(data)
    class Error<T>(message: String, data: T? = null) : ScreenState<T>(data, message)
    class Loading<T> : ScreenState<T>(null)
}