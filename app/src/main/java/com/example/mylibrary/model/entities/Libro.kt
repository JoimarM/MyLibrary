package com.example.mylibrary.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libro_table")
class Libro(
    @PrimaryKey val name: String,

    ) {
}