package com.example.mylibrary.model.entities

import androidx.room.Entity

@Entity
data class Libro(
    val name: String,
    val id: String,
    val escritor: String
) {
}