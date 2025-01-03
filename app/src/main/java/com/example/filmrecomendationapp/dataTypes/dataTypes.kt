package com.example.filmrecomendationapp.dataTypes

data class Movie(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = emptyList(),
    val id: Int = 0,
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class MoviePage(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)


data class MovieRating(
    val id: Int,
    val rating: Int
)