package com.example.filmrecomendationapp

import FilmRecomendationViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.filmrecomendationapp.ui.MovieDetailsScreen
import com.example.filmrecomendationapp.ui.HistoryScreen
import com.example.filmrecomendationapp.ui.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

enum class FilmRecomendationScreen() {
    Home,
    MovieDetails,
    History
}

@Composable
fun FilmRecomendationApp(viewModel: FilmRecomendationViewModel = viewModel(),
                   navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController,
        startDestination = FilmRecomendationScreen.Home.name
    ) {
        composable(route = FilmRecomendationScreen.Home.name) {
            HomeScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = FilmRecomendationScreen.MovieDetails.name) {
            MovieDetailsScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = FilmRecomendationScreen.History.name) {
            HistoryScreen(viewModel = viewModel, navController = navController)
        }
    }
}