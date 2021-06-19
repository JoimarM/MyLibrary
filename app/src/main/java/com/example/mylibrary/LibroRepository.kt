package com.example.mylibrary

import androidx.annotation.WorkerThread
import com.example.mylibrary.model.daos.LibroDAO
import com.example.mylibrary.model.entities.Libro
import kotlinx.coroutines.flow.Flow

class LibroRepository(private val libroDAO: LibroDAO) {

    val allBooks: Flow<List<Libro>> = libroDAO.allLibros()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(libro: Libro) {
        libroDAO.insertarLibro(libro)
    }
}
