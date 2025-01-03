package com.example.filmrecomendationapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.filmrecomendationapp.dataTypes.Movie

@Entity(tableName = "watched-films")
@TypeConverters(MovieListTypeConverters::class)
data class WatchedFilmsEntity(
    @PrimaryKey val filmId: Int,
    val watched: Boolean
)

@Entity(tableName = "film-ratings")
data class FilmRatingsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val filmId: Int,
    val rating: Int
)
