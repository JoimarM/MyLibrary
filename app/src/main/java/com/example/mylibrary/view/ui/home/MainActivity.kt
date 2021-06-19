package com.example.mylibrary.view.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.mylibrary.*

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private val libroViewModel: LibroViewModel by viewModels {
        LibroViewModel.LibroViewModelFactory((application as MyLibraryApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val recyclerView = findViewById<RecyclerView>(R.id.rvLibros)
        val adapter = LibrosAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        libroViewModel.allBooks.observe(this) { libros ->
            libros.let { adapter.submitList(it) }
        }

        val intent = Intent(this@MainActivity, AddBook::class.java)
        startActivityForResult(intent, newWordActivityRequestCode)



    }


}