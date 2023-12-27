package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PenangFood : AppCompatActivity() {
    lateinit var pgfoodhomebtn: Button
    lateinit var pgfoodbackbtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penang_food)

        pgfoodhomebtn = findViewById(R.id.pgfoodhomebtn)
        pgfoodbackbtn = findViewById(R.id.pgfoodbackbtn)

        pgfoodhomebtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }

        pgfoodbackbtn.setOnClickListener {
            val intent = Intent(this, penang_page::class.java)
            startActivity(intent)
        }
    }
}