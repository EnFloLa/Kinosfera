package com.example.proyecto_dam1_kinosfera.services

    import android.content.ContentValues
    import android.content.Context
    import android.provider.BaseColumns
    import com.example.proyecto_dam1_kinosfera.config.BaseDatos
    import com.example.proyecto_dam1_kinosfera.config.TABLE_DIRECTOR_NAME
    import com.example.proyecto_dam1_kinosfera.core.Director

    class DirectorService (context: Context) {
        val dbHelper = BaseDatos(context)

        fun insertarNewDirec(parDirec: Director): Director? {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("nombre", parDirec.nombre)
                put("pelicula", parDirec.pelicula)
            }
            val newRowId = db?.insert(
                TABLE_DIRECTOR_NAME,
                null,
                values
            )
            cerrarDB()
            return if (newRowId != null) getDirec(newRowId.toLong()) else null
        }

        fun getDirec(idDirecGc: Long): Director? {
            val db = dbHelper.readableDatabase
            val projection = arrayOf(
                BaseColumns._ID,
                "nombre",
                "pelicula"
            )
            val selection = "${BaseColumns._ID} = ?"
            val selectionArgs = arrayOf("$idDirecGc")
            val cursor = db.query(
                TABLE_DIRECTOR_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
            )

            with(cursor) {
                if (cursor.count == 1) {
                    while (moveToNext()) {
                        val nombre = getString(getColumnIndexOrThrow("nombre"))
                        val pelicula = getString(getColumnIndexOrThrow("pelicula"))
                        val directorId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                        val direcObJ = Director(
                            directorId,
                            nombre,
                            pelicula
                        )
                        cerrarDB()
                        return direcObJ
                    }
                } else {
                    return null
                }
            }
            return null
        }

        fun getDirecs(): MutableMap<Int, Director> {
            val db = dbHelper.readableDatabase
            val projection = arrayOf(
                BaseColumns._ID,
                "nombre",
                "pelicula"
            )
            val cursor = db.query(
                TABLE_DIRECTOR_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )
            val usersObjs = mutableMapOf<Int, Director>()
            with(cursor) {
                while (moveToNext()) {
                    val index = getInt(getColumnIndexOrThrow(BaseColumns._ID))
                    val nombre = getString(getColumnIndexOrThrow("nombre"))
                    val pelicula = getString(getColumnIndexOrThrow("pelicula"))
                    val userId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                    val userObJ = Director(
                        userId,
                        nombre,
                        pelicula
                    )
                    usersObjs.put(index, userObJ)
                }
            }
            cerrarDB()
            return usersObjs
        }

        fun cerrarDB(){
            dbHelper.close()
        }
    }
