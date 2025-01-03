package com.example.filmrecomendationapp.ui

import FilmRecomendationViewModel
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.getSystemService
import androidx.core.graphics.values
import coil.compose.AsyncImage


@Composable
fun HomeScreen(viewModel: FilmRecomendationViewModel = viewModel(),
               navController: NavController) {

    val sensorManager = LocalContext.current.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    var background by remember { mutableStateOf(Color.White) }

    val lightSensorListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val luminance = event.values[0]/100.0f
                background = Color(luminance, luminance, luminance)

        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // Handle accuracy changes (optional)
        }
    }
    LaunchedEffect(key1 = lightSensor) {
        if (lightSensor != null) {
            sensorManager.registerListener(lightSensorListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    val uiState = viewModel.uiState.collectAsState().value

    val systemBarHeight = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()

    @Composable
    fun MovieCard(movie: Movie, navController: NavController) {

        AsyncImage(
            model = "https://image.tmdb.org/t/p/original"+movie.poster_path,
            contentDescription = "Example Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    navController.navigate(FilmRecomendationScreen.MovieDetails.name)
                    viewModel.setCurrentMovie(movie)
                }
        )


    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = systemBarHeight.value.dp)
            .background(background)

    ) {
        Text(text = "Recommended Movies: ", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
        LazyRow (modifier = Modifier.padding(3.dp)){items(uiState.movies){ movie -> MovieCard(movie, navController)}}

        Text(text = "Top rated: ", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
        LazyRow (modifier = Modifier.padding(3.dp)){items(uiState.movies){ movie -> MovieCard(movie, navController)}}

        Text(text = "New releases: ", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
        LazyRow (modifier = Modifier.padding(3.dp)){items(uiState.movies){ movie -> MovieCard(movie, navController)}}

    }


}





