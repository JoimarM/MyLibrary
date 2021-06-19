package com.example.mylibrary

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyLibraryApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { BibliotecaDB.getDatabase(this, applicationScope) }
    val repository by lazy { LibroRepository(database.libroDAO()) }
}