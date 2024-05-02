package com.example.proyecto_dam1_kinosfera.core

class Director {

    var directorId: Long
    var nombre: String
    var pelicula: String

    constructor(
        directorId: Long,
        nombre: String,
        pelicula: String,
    ) {
        this.directorId = directorId
        this.nombre = nombre
        this.pelicula = pelicula
    }

    constructor() {
        this.directorId = 1
        this.nombre = ""
        this.pelicula = ""
    }
}