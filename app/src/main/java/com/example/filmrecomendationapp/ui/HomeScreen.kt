package com.example.filmrecomendationapp.ui

import FilmRecomendationViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.filmrecomendationapp.R
import com.example.filmrecomendationapp.FilmRecomendationScreen
import com.example.filmrecomendationapp.dataTypes.Movie
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

val exampleMovie = Movie("Example Movie", "Action", 4.5f, "https://xl.movieposterdb.com/24_09/2024/9218128/xl_gladiator-ii-movie-poster_c9934359.jpg")


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: FilmRecomendationViewModel = viewModel(),
               navController: NavController
) {

    val uiState = viewModel.uiState.collectAsState().value



    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Films",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.List,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }


}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val systemBarHeight = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = innerPadding.calculateTopPadding())

    ) {
        Text(text = "Recommended Movies: ", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
        LazyRow (modifier = Modifier.padding(3.dp)){ items(7){ MovieCard(exampleMovie)}}

        Text(text = "Top rated: ", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
        LazyRow (modifier = Modifier.padding(3.dp)){ items(7){ MovieCard(exampleMovie)}}

        Text(text = "New releases: ", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
        LazyRow (modifier = Modifier.padding(3.dp)){ items(7){ MovieCard(exampleMovie)}}

    }
}


@Composable
fun MovieCard(movie: Movie) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
        .width(150.dp)
        .padding(8.dp)
    ) {
//        Image(
//        painter = rememberAsyncImagePainter("https://xl.movieposterdb.com/24_09/2024/9218128/xl_gladiator-ii-movie-poster_c9934359.jpg"),
//        contentDescription = null,
//        modifier = Modifier.fillMaxSize(),
//        contentScale = ContentScale.Crop
//    )
        Column {

            // Image(painter = rememberImagePainter(movie.posterUrl), contentDescription = null)
            Text(text = movie.title, modifier = Modifier.padding(8.dp))
            Text(text = movie.genre, modifier = Modifier.padding(8.dp))
            Text(text = "Rating: ${movie.rating}", modifier = Modifier.padding(8.dp))
        }
    }
}

