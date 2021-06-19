package com.example.mylibrary

import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.model.entities.Libro
import kotlinx.coroutines.launch

class LibroViewModel(private val repository: LibroRepository) : ViewModel() {
    val allBooks: LiveData<List<Libro>> = repository.allBooks.asLiveData()

    fun insert(libro: Libro) = viewModelScope.launch {
        repository.insert(libro)
    }

    class LibroViewModelFactory(private val repository: LibroRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LibroViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return LibroViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}