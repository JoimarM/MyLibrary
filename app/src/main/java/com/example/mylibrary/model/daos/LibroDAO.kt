package com.example.mylibrary.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mylibrary.model.entities.Libro

@Dao
interface LibroDAO {

    @Query("SELECT * from Libro")
    fun AllLibros(): List<Libro>

    @Query("SELECT * FROM Libro WHERE id= :id")
    fun getLibro(id: String): Libro

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertarUsuario(libro: List<Libro>)
}