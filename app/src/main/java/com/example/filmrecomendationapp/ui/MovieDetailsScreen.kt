package com.example.filmrecomendationapp.ui

import FilmRecomendationViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage


@Composable
fun MovieDetailsScreen(viewModel: FilmRecomendationViewModel = viewModel(),
                       navController: NavController
) {

    val uiState = viewModel.uiState.collectAsState().value
    //var goalInput by remember { mutableStateOf(uiState.stepGoal.toString()) }
    val systemBarHeight = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val movie = uiState.currentMovie


    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(Color(0xfff8f9fa))
    ) {
        AsyncImage(model = "https://image.tmdb.org/t/p/original"+movie.poster_path,"",contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
        )
        Text(text = movie.title, fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 20.dp))
        Text(text = movie.overview, fontSize = 20.sp, textAlign = TextAlign.Center
            ,modifier = Modifier.padding(10.dp))

        Text(text = "${movie.vote_average}/10", fontSize = 40.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
            ,modifier = Modifier.padding(40.dp)
                .fillMaxWidth())

        Box(modifier = Modifier.align(androidx.compose.ui.Alignment.CenterHorizontally)) {
            if (uiState.movieWatched) {
                Button(onClick = { viewModel.setMovieWatched(false) }) {
                    Text("Watched")
                }
            } else {

                OutlinedButton(onClick = { viewModel.setMovieWatched(true) }) {
                    Text("Mark as watched")
                }
            }
        }

    }
}
