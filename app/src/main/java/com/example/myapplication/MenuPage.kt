package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase

class MenuPage : AppCompatActivity() {
    lateinit var penangpic: ImageView
    lateinit var sarawakpic: ImageView
    lateinit var klpic: ImageView
    lateinit var malaccapic: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)
        penangpic = findViewById(R.id.penangpic)
        sarawakpic = findViewById(R.id.sarawakpic)
        klpic = findViewById(R.id.klpic)
        malaccapic = findViewById(R.id.malaccapic)

        penangpic.setOnClickListener {
            val intent = Intent(this, penang_page::class.java)
            startActivity(intent)
        }

        sarawakpic.setOnClickListener {
            val intent = Intent(this, sarawak_page::class.java)
            startActivity(intent)
        }

        klpic.setOnClickListener {
            val intent = Intent(this,kl_page::class.java)
            startActivity(intent)
        }

        malaccapic.setOnClickListener {
            val intent = Intent(this, malacca_page::class.java)
            startActivity(intent)
        }

    }
}