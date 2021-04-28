package com.example.mylibrary.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mylibrary.model.entities.Usuario

@Dao
interface UsuarioDAO {

    @Query("SELECT * from Usuario")
    fun AllUsuarios(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id= :id")
    fun getUsuario(id: String): Usuario

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertarUsuario(usuario: Usuario)

}