package com.example.filmrecomendationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.filmrecomendationapp.ui.theme.FilmRecomendationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FilmRecomendationAppTheme {
                FilmRecomendationApp()
            }
        }
    }
}

