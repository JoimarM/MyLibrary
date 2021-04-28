package com.example.mylibrary.model.entities

import androidx.room.Entity
import com.example.mylibrary.model.entities.Libro

@Entity
data class Usuario(
    val id: String,
    val nombre: String,
    var prestamo: List<Libro>
) {
}