package com.example.proyecto_dam1_kinosfera.config
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

const val TABLE_DIRECTOR_NAME = "DirectoresL"
private const val SQL_CREATE_ENTRIES = "CREATE TABLE $TABLE_DIRECTOR_NAME (" + "${BaseColumns._ID} INTEGER PRIMARY KEY," + "nombre TEXT," + "pelicula TEXT)"
private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_DIRECTOR_NAME"

class BaseDatos(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Temporal.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
        db.execSQL("INSERT INTO $TABLE_DIRECTOR_NAME(${BaseColumns._ID},nombre,pelicula) VALUES" + "(1,'Damien Chazelle','Whiplash')")
        db.execSQL("INSERT INTO $TABLE_DIRECTOR_NAME(${BaseColumns._ID},nombre,pelicula) VALUES" + "(2,'Jean-Luc Godard','Masculin Féminin')")
        db.execSQL("INSERT INTO $TABLE_DIRECTOR_NAME(${BaseColumns._ID},nombre,pelicula) VALUES" + "(3,'Quentin Tarantino','Reservoir Dogs')")
        db.execSQL("INSERT INTO $TABLE_DIRECTOR_NAME(${BaseColumns._ID},nombre,pelicula) VALUES" + "(4,'Stanley Kubrick','A Clockwork Orange')")

        Log.d("DB", "BASE DE DATOS CREADA CON EXITO")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate (db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}

