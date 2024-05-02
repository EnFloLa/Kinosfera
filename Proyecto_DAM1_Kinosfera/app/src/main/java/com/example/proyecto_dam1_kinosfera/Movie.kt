package com.example.proyecto_dam1_kinosfera

data class MovieRes(
    val estreno: List<Movie>,
    val terror: List<Movie>,
    val accion: List<Movie>,
    val comedia: List<Movie>,
    val series: List<Movie>,
    val proximo: List<Movie>
)

data class Movie(
    val description: String,
    val id: Int,
    val photo: String,
    val title: String,
    val url: String,
    val year: Int
)

