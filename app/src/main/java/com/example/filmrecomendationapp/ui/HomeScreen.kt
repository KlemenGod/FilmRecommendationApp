package com.example.filmrecomendationapp.ui

import FilmRecomendationViewModel
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

@Composable
fun HomeScreen(viewModel: FilmRecomendationViewModel = viewModel(),
               navController: NavController
) {

    val uiState = viewModel.uiState.collectAsState().value


    /*Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "${uiState.stepCount} / ${uiState.stepGoal} Steps",
            fontSize = 28.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LinearProgressIndicator(
            progress = uiState.stepCount.toFloat() / uiState.stepGoal,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Navigate to GoalScreen
        Button(onClick = {navController.navigate(FilmRecomendationScreen.Goal.name)}) {
            Text(text = stringResource(R.string.daily_goal))
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Navigate to HistoryScreen
        Button(onClick = {navController.navigate(FilmRecomendationScreen.History.name)}) {
            Text(text = stringResource(R.string.history))
        }


    }*/
}



@Composable
fun MovieCard(movie: Movie) {
    Card(modifier = Modifier
        .width(150.dp)
        .padding(8.dp)
    ) {
        Column {
            // Image(painter = rememberImagePainter(movie.posterUrl), contentDescription = null)
            Text(text = movie.title, modifier = Modifier.padding(8.dp))
            Text(text = movie.genre, modifier = Modifier.padding(8.dp))
            Text(text = "Rating: ${movie.rating}", modifier = Modifier.padding(8.dp))
        }
    }
}

