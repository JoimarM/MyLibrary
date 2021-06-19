package com.example.mylibrary

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddBook : AppCompatActivity() {
    private lateinit var editLibroView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        editLibroView = findViewById(R.id.editTextNombre)

    val button = findViewById<Button>(R.id.btnGuardar)
        button.setOnClickListener{
        val replyIntent = Intent()
            if (TextUtils.isEmpty(editLibroView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val libro = editLibroView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, libro)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

}