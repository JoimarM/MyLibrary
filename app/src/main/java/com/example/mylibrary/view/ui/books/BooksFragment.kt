package com.example.mylibrary.view.ui.users

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.*
import com.example.mylibrary.model.entities.Libro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BooksFragment : Fragment() {
    private val newWordActivityRequestCode = 1
    private val libroViewModel: LibroViewModel by viewModels {
        LibroViewModel.LibroViewModelFactory((activity as MyLibraryApp).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = inflater.inflate(R.layout.fragment_books, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.rvLibros)
        val adapter = LibrosAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        libroViewModel.allBooks.observe(requireActivity()) { libros ->
            libros.let { adapter.submitList(it) }
        }

        val btnAgregarLibro: FloatingActionButton = root.findViewById(R.id.agregarLibroFAB)
        btnAgregarLibro.setOnClickListener(View.OnClickListener {
            val intent = Intent(this.context, AddBook::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        })
        return root
    }


}