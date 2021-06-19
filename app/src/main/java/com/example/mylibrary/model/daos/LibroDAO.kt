package com.example.mylibrary.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mylibrary.model.entities.Libro
import kotlinx.coroutines.flow.Flow

@Dao
interface LibroDAO {

    @Query("SELECT * from libro")
    fun allLibros(): Flow<List<Libro>>


    @Query("SELECT * FROM libro WHERE id= :id")
    fun getLibro(id: String): Libro

    @Insert
    fun insertarLibro(libro: Libro)

    @Query("DELETE FROM libro")
    abstract suspend fun deleteAll()
}