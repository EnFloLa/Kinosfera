package com.example.proyecto_dam1_kinosfera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.proyecto_dam1_kinosfera.core.Director
import com.example.proyecto_dam1_kinosfera.services.DirectorService

class RegistrateActivity : AppCompatActivity() {

    var directorService = DirectorService(this)

    private lateinit var nombre : EditText
    private lateinit var pelicula : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrate)

        nombre = findViewById(R.id.txtNombre)
        pelicula = findViewById(R.id.txtPelicula)

        val new = findViewById<Button>(R.id.btnRegDirec)
        new.setOnClickListener{
            val newDirec = Director(1, nombre.getText().toString(), pelicula.getText().toString())
            directorService.insertarNewDirec(newDirec)
        }
    }
}