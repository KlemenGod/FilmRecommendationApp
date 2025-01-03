package com.example.filmrecomendationapp.data

import com.example.filmrecomendationapp.dataTypes.Movie
import com.example.filmrecomendationapp.dataTypes.MovieRating


interface FilmRepository {
    suspend fun getWatchedFilms(): List<WatchedFilmsEntity>
    suspend fun setWatchedFilm(filmId: Int, watched: Boolean) : Unit
    suspend fun getWatchedFilm(filmId: Int): Boolean

    suspend fun getFilmRatings(): List<MovieRating>
    suspend fun addFilmRating(id: Int,rating: Int)
    suspend fun updateFilmRating(id: Int,rating: Int)
    suspend fun getFilmRating(id: Int): Int



}