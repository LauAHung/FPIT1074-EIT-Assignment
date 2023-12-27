package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class penang_page : AppCompatActivity() {
    lateinit var pgfoodbtn: ImageView
    lateinit var pgplacesbtn: ImageView
    lateinit var pgsacbtn: ImageView
    lateinit var pgfesbtn: ImageView
    lateinit var pgbackbtn: Button
    lateinit var pghomebtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penang_page)
        pgfoodbtn = findViewById(R.id.pgfoodbtn)
        pgplacesbtn = findViewById(R.id.pgplacesbtn)
        pgsacbtn = findViewById(R.id.pgsacbtn)
        pgfesbtn = findViewById(R.id.pgfesbtn)
        pgbackbtn = findViewById(R.id.pgbackbtn)
        pghomebtn = findViewById(R.id.pghomebtn)


        pgfoodbtn.setOnClickListener {
            val intent = Intent(this, PenangFood::class.java)
            startActivity(intent)
        }

        pgplacesbtn.setOnClickListener {
            val intent = Intent(this, penang_places::class.java)
            startActivity(intent)
        }

        pgsacbtn.setOnClickListener {
            val intent = Intent(this, penang_streetart::class.java)
            startActivity(intent)
        }

        pgfesbtn.setOnClickListener {
            val intent = Intent(this, penang_festival_events::class.java)
            startActivity(intent)
        }

        pgbackbtn.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivity(intent)
        }

        pghomebtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }
    }
}