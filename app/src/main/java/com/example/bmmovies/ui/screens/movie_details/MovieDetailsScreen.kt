package com.example.bmmovies.ui.screens.movie_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.bmmovies.R
import com.example.bmmovies.ui.screens.movie_details.components.AppBarWithArrow


@ExperimentalCoilApi
@Composable
fun MovieDetailsScreen(
    navController: NavController,
) {
    val movieDetailsViewModel = hiltViewModel<MovieDetailsViewModel>()
    val movieDetailsState = movieDetailsViewModel.screenState.collectAsState().value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AppBarWithArrow(title = movieDetailsState.data?.title ?: "")
        {
            navController.navigateUp()
        }
        Image(
            painter = rememberImagePainter(data = movieDetailsState.data?.posterImage),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentDescription = movieDetailsState.data?.title,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(240.dp)
            ) {

                Image(
                    painter = rememberImagePainter(data = movieDetailsState.data?.posterImage),
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp)),
                    contentDescription = movieDetailsState.data?.title,
                    contentScale = ContentScale.Crop
                )
            }
            movieDetailsState.data?.let { movie ->
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = movie.title,
                        fontSize = 19.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.padding(start = 16.dp)
                    ) {
//                            RatingBar(
//                                starsModifier = Modifier.size(18.dp),
//                                rating = movie.voteCount / 2
//                            )

                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = movie.voteCount.take(3),
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            maxLines = 1,
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

//                        Text(
//                            modifier = Modifier.padding(start = 16.dp),
//                            text = stringResource(R.string.language) + movie.original_language
//                        )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp),
                        text = stringResource(R.string.release_date) + movie.releaseDate
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color.White,
                        text = movie.voteCount + stringResource(R.string.votes)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(R.string.overview),
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        movieDetailsState.data?.let {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = it.overview,
                fontSize = 16.sp,
                color = Color.White,
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}