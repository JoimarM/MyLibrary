package com.example.mylibrary.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mylibrary.model.entities.Libro

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val nombre: String,
    var prestamo: List<Libro>
) {
}