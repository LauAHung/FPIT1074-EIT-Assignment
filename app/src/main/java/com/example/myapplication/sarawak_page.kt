package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class sarawak_page : AppCompatActivity() {
    lateinit var sarawakfoodbtn: ImageView
    lateinit var sarawakplacesbtn: ImageView
    lateinit var sarawakcfbtn: ImageView
    lateinit var srwcnbtn: ImageView
    lateinit var srwbackbtn: Button
    lateinit var srwhomebtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sarawak_page)
        sarawakfoodbtn = findViewById(R.id.sarawakfoodbtn)
        sarawakplacesbtn = findViewById(R.id.sarawakplacesbtn)
        sarawakcfbtn = findViewById(R.id.sarawakcfbtn)
        srwcnbtn = findViewById(R.id.srwcnbtn)
        srwbackbtn = findViewById(R.id.srwbackbtn)
        srwhomebtn = findViewById(R.id.srwhomebtn)

        sarawakfoodbtn.setOnClickListener {
            val intent = Intent(this, sarawak_food::class.java)
            startActivity(intent)
        }

        sarawakplacesbtn.setOnClickListener {
            val intent = Intent(this, SarawakPlaces::class.java)
            startActivity(intent)
        }

        sarawakcfbtn.setOnClickListener {
            val intent = Intent(this, sarawak_cf::class.java)
            startActivity(intent)
        }

        srwcnbtn.setOnClickListener {
            val intent = Intent(this, sarawak_caving_adventures::class.java)
            startActivity(intent)
        }

        srwbackbtn.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivity(intent)
        }

        srwhomebtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }
    }
}