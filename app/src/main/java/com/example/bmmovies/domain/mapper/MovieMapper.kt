package com.example.bmmovies.domain.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.bmmovies.domain.entities.local.Movie
import com.example.bmmovies.domain.entities.remote.RemoteMovie
import javax.inject.Inject

class MovieMapper @Inject constructor() : ModelMapper<RemoteMovie, Movie> {
    override fun convert(from: RemoteMovie?): Movie {
        return from?.let {
            Movie(
                id = it.id ?: 0,
                title = it.title.orEmpty(),
                releaseDate = it.releaseDate.orEmpty(),
                posterImage = posterBaseUrl + (it.posterPath.orEmpty()),
                rating = (it.voteAverage?.div(2.0f)) ?: 0.0f,
                overview = it.overview.orEmpty()
            )
        } ?: Movie()
    }

    companion object {
        private const val posterBaseUrl = "https://image.tmdb.org/t/p/w200"
    }
}