package com.example.filmrecomendationapp

import AppContainer
import AppDataContainer
import android.app.Application
import com.example.filmrecomendationapp.data.FilmRecommendationDatabase

class FilmRecommendationApplication : Application() {


    //The instance of AppContainer is used by other
    // classes to obtain dependencies.
    lateinit var repository: AppContainer

    override fun onCreate() {
        super.onCreate()
        val database = FilmRecommendationDatabase.getDatabase(this)
        repository = AppDataContainer(this)
    }
}