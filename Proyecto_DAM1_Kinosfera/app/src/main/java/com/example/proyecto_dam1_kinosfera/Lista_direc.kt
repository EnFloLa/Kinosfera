package com.example.proyecto_dam1_kinosfera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam1_kinosfera.core.Director
import com.example.proyecto_dam1_kinosfera.services.DirectorService

class Lista_direc : AppCompatActivity() {
    var directorService = DirectorService(this)

    lateinit var listaUsuariosLocal: MutableMap<Int, Director>
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_direc)

        listaUsuariosLocal = directorService.getDirecs()

        recycler = findViewById(R.id.mis_usuarios_recycler_view)

        val adapter = DirectorAdapter(listaUsuariosLocal)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        recycler.adapter = adapter

        val sigact = findViewById<Button>(R.id.btnCrearDirec)
        sigact.setOnClickListener{
            val intent = Intent(this,RegistrateActivity::class.java)
            startActivity(intent)
        }
    }
}