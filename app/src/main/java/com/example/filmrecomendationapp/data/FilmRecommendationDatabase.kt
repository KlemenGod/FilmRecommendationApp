package com.example.filmrecomendationapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(MovieListTypeConverters::class)
@Database(entities = [WatchedFilmsEntity::class, FilmRatingsEntity::class], version = 1, exportSchema = false)
abstract class FilmRecommendationDatabase : RoomDatabase() {

    abstract fun watchedFilmsDao(): WatchedFilmsDao
    abstract fun filmRatingsDao(): FilmRatingsDao

    companion object {

        //The value of a variable annotated with @Volatile is never cache.
        //R/W operations are the from/to main memory.
        @Volatile
        private var INSTANCE: FilmRecommendationDatabase? = null

        // if the INSTANCE is not null, return it, otherwise create a new database instance.
        fun getDatabase(context: Context): FilmRecommendationDatabase {
            val a = synchronized(this) {
                Room.databaseBuilder(
                    context,
                    FilmRecommendationDatabase::class.java,
                    "film_recommendation_database"
                )
                    .build()
            }
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, FilmRecommendationDatabase::class.java, "film_recommendation_database")

                    .build()
                    .also { INSTANCE = it }
            }

        }
    }


}