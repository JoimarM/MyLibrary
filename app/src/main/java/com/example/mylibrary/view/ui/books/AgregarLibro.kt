package com.example.mylibrary.view.ui.books

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.mylibrary.R
import com.example.mylibrary.databinding.FragmentAgregarLibroBinding
import com.example.mylibrary.BibliotecaDB
import com.example.mylibrary.model.entities.Libro

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarLibro.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarLibro : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
     private lateinit var nombre: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentAgregarLibroBinding>(
            inflater,
            R.layout.fragment_agregar_libro,
            container,
            false
        )


        binding.btnGuardar.setOnClickListener {
        val repyIntent = Intent()
        val libro = binding.editTextNombre.text.toString()
        repyIntent.putExtra(EXTRA_REPLY,libro)
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_libro, container, false)
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }


}