package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class penang_places : AppCompatActivity() {
    lateinit var pgcjhomebtn: Button
    lateinit var pgcjbackbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penang_places)

        pgcjhomebtn = findViewById(R.id.pgcjhomebtn)
        pgcjbackbtn = findViewById(R.id.pgcjbackbtn)

        pgcjhomebtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }

        pgcjbackbtn.setOnClickListener {
            val intent = Intent(this, penang_page::class.java)
            startActivity(intent)
        }
    }
}