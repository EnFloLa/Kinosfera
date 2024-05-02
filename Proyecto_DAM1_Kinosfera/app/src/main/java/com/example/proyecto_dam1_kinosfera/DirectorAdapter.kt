package com.example.proyecto_dam1_kinosfera

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam1_kinosfera.core.Director

class DirectorAdapter (private val data: MutableMap<Int, Director>?) :
    RecyclerView.Adapter<DirectorAdapter.DirectorHolder>() {

    inner class DirectorHolder(val v: View) : RecyclerView.ViewHolder(v) {

        var nombreItemLista: TextView
        var peliculaItemLista: TextView

        init {
            nombreItemLista = v.findViewById(R.id.nombre_item_lista)
            peliculaItemLista = v.findViewById(R.id.pelicula_item_lista)
        }

        fun bindData(data: Director) = with(v) {
            nombreItemLista.text = "Nombre: ${data.nombre}"
            peliculaItemLista.text = "Pelicula: ${data.pelicula}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectorHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return DirectorHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: DirectorHolder, position: Int) {
        data?.let {
            it.get(position + 1)?.let { it1 -> holder.bindData(it1) }
        }
    }
}