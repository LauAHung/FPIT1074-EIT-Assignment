package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class penang_streetart : AppCompatActivity() {
    lateinit var pgsahomebtn: Button
    lateinit var pgsabackbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penang_streetart)
        pgsahomebtn = findViewById(R.id.pgsahomebtn)
        pgsabackbtn = findViewById(R.id.pgsabackbtn)

        pgsahomebtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }

        pgsabackbtn.setOnClickListener {
            val intent = Intent(this, penang_page::class.java)
            startActivity(intent)
        }
    }
}