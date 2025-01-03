package com.example.filmrecomendationapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface WatchedFilmsDao {
    @Query("SELECT * FROM `watched-films`")
    suspend fun getWatchedFilms(): List<WatchedFilmsEntity>

    @Query("SELECT * FROM `watched-films` WHERE filmId = :filmId")
    suspend fun getWatchedFilm(filmId: Int): WatchedFilmsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setWatchedFilm(watchedFilm: WatchedFilmsEntity)
}

@Dao
interface FilmRatingsDao {
    @Query("SELECT * FROM `film-ratings`")
    suspend fun getFilmRatings(): List<FilmRatingsEntity>

    @Insert
    suspend fun addFilmRating(filmRating: FilmRatingsEntity)

    @Update
    suspend fun updateFilmRating(filmRating: FilmRatingsEntity)

    @Query("SELECT * from `film-ratings` WHERE id = :id")
    fun getFilmRating(id: Int): FilmRatingsEntity
}