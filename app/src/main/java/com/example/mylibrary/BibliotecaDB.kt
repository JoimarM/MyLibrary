package com.example.mylibrary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mylibrary.model.daos.LibroDAO
import com.example.mylibrary.model.daos.UsuarioDAO
import com.example.mylibrary.model.entities.Libro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = arrayOf(Libro::class), version = 1
)
abstract class BibliotecaDB: RoomDatabase() {

    abstract fun libroDAO(): LibroDAO
    abstract fun usuarioDao(): UsuarioDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BibliotecaDB? = null

        fun getDatabase(context: Context, scope:CoroutineScope): BibliotecaDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BibliotecaDB::class.java,
                    "word_database"
                ).addCallback(WordDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.libroDAO())
                }
            }
        }

        suspend fun populateDatabase(libroDao: LibroDAO) {
            // Delete all content here.
            libroDao.deleteAll()

            // Add sample words.
            var libro = Libro("Veraneo")
           libroDao.insertarLibro(libro)
            libro = Libro("La Selva")
            libroDao.insertarLibro(libro)
            // TODO: Add your own words!
        }
    }
}