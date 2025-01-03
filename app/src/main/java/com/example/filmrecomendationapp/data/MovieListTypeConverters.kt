package com.example.filmrecomendationapp.data

import androidx.compose.ui.input.key.type
import androidx.room.TypeConverter
import com.example.filmrecomendationapp.dataTypes.Movie
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

class MovieListTypeConverters {
    @TypeConverter
    fun fromMovieList(movieList: List<Movie>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Movie>>() {}.type
        return gson.toJson(movieList, type)
    }

    @TypeConverter
    fun toMovieList(movieListJson: String): List<Movie> {
        val gson = Gson()
        val type = object : TypeToken<List<Movie>>() {}.type
        return gson.fromJson(movieListJson, type)
    }

    @TypeConverter
    fun fromMovie(movie: Movie): String {
        val gson = Gson()
        return gson.toJson(movie)
    }

    @TypeConverter
    fun toMovie(movieJson: String): Movie {
        val gson = Gson()
        val type = object : TypeToken<Movie>() {}.type
        return gson.fromJson(movieJson, type)
    }
}