package com.example.mylibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.model.entities.Libro

class LibrosAdapter : ListAdapter<Libro, LibrosAdapter.LibroViewHolder>(LIBROS_COMPARATOR) {

    class LibroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val libroItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            libroItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): LibroViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_libro, parent, false)
                return LibroViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        return LibroViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }

    companion object {
        private val LIBROS_COMPARATOR = object : DiffUtil.ItemCallback<Libro>() {
            override fun areItemsTheSame(oldItem: Libro, newItem: Libro): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Libro, newItem: Libro): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}