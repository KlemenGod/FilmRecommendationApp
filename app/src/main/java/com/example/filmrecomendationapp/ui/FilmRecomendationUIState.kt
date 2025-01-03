package com.example.filmrecomendationapp.ui

import com.example.filmrecomendationapp.data.WatchedFilmsEntity
import com.example.filmrecomendationapp.dataTypes.Movie
import com.example.filmrecomendationapp.dataTypes.MovieRating

data class FilmRecomendationUIState(


    val currentMovie: Movie = Movie(),
    val movieWatched: Boolean = false,
    val movieRating: MovieRating = MovieRating(0,0),
    val movies: List<Movie> = listOf(),
    val watchedFilms: List<WatchedFilmsEntity> = listOf(),
    val ratings: List<MovieRating> = listOf()
)

