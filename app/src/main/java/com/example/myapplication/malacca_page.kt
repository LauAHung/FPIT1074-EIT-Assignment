package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class malacca_page : AppCompatActivity() {
    lateinit var malaccafoodbtn: ImageView
    lateinit var malaccaplacesbtn: ImageView
    lateinit var malaccamngbtn: ImageView
    lateinit var malaccafnebtn: ImageView
    lateinit var mlcbackbtn: Button
    lateinit var mlchomebtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malacca_page)
        malaccafoodbtn = findViewById(R.id.malaccafoodbtn)
        malaccaplacesbtn = findViewById(R.id.malaccaplacesbtn)
        malaccamngbtn = findViewById(R.id.malaccamngbtn)
        malaccafnebtn = findViewById(R.id.malaccafnebtn)
        mlcbackbtn = findViewById(R.id.mlcbackbtn)
        mlchomebtn = findViewById(R.id.mlchomebtn)

        malaccafoodbtn.setOnClickListener {
            val intent = Intent(this, malacca_food::class.java)
            startActivity(intent)
        }

        malaccaplacesbtn.setOnClickListener {
            val intent = Intent(this, malacca_places::class.java)
            startActivity(intent)
        }

        malaccamngbtn.setOnClickListener {
            val intent = Intent(this, malacca_museumsandgalleries::class.java)
            startActivity(intent)
        }

        malaccafnebtn.setOnClickListener {
            val intent = Intent(this, malacca_cf::class.java)
            startActivity(intent)
        }

        mlcbackbtn.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivity(intent)
        }

        mlchomebtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }

    }
}