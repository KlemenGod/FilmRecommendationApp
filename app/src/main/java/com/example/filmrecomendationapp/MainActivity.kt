package com.example.filmrecomendationapp

import FilmRecomendationViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.filmrecomendationapp.ui.FilmRecommendationViewModelFactory
import com.example.filmrecomendationapp.ui.theme.FilmRecomendationAppTheme


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: FilmRecomendationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = (application as FilmRecommendationApplication).repository.filmRepository

        // Initialize the ViewModel using the factory
        val viewModelFactory = FilmRecommendationViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FilmRecomendationViewModel::class.java)


        enableEdgeToEdge()
        setContent {
            FilmRecomendationAppTheme {
                FilmRecomendationApp(viewModel = viewModel)
            }
        }
    }
}

