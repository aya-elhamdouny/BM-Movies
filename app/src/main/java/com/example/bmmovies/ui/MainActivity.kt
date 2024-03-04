package com.example.bmmovies.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bmmovies.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private val viewModel: MoviesListingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val result = viewModel.getUpcomingMoviesData()
            val result1 = viewModel.getNowPlayingMoviesData()
            val result2 = viewModel.getPopularMoviesMoviesData()
            val de = viewModel.getDetailData()

        }


    }
}