package com.example.proyecto_dam1_kinosfera

import retrofit2.Response
import retrofit2.http.GET

interface Endpoints {
    @GET("/JavierAvila19/apimoviles/main/db.json")
    suspend fun getDataMovies():Response<MovieRes>

}