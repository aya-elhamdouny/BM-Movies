package com.example.bmmovies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.bmmovies.R
import com.example.bmmovies.domain.entities.local.Movie

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieListItem(navController: NavController, movie: Movie) {
    Box(
        Modifier
            .clickable {
//                navController.navigate(Screen.Detail.createRoute(movie.id.toString()))
            }
            .fillMaxWidth()) {
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(data = movie.posterImage),
                contentDescription = null,
                modifier = Modifier.size(500.dp, 400.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight()
                    .align(CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movie.title,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(10.dp))
                Text(text = movie.releaseDate, color = Color.Black, fontSize = 14.sp)
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = movie.rating.toString(), color = Color.Black, fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "rating",
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .height(0.7.dp)
        )
    }
}