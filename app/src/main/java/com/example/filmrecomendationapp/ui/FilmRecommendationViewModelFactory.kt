package com.example.filmrecomendationapp.ui

import FilmRecomendationViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmrecomendationapp.data.FilmRepository


//Provides Factory to create instance of ViewModel for the entire app
class FilmRecommendationViewModelFactory(private val repository: FilmRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmRecomendationViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FilmRecomendationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}