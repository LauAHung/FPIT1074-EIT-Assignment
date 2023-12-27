package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class kl_page : AppCompatActivity() {
    lateinit var klfoodbtn: ImageView
    lateinit var klplacesbtn: ImageView
    lateinit var klmibtn: ImageView
    lateinit var klsebtn: ImageView
    lateinit var srwbackbtn: Button
    lateinit var srwhomebtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kl_page)
        klfoodbtn = findViewById(R.id.klfoodbtn)
        klplacesbtn = findViewById(R.id.klplacesbtn)
        klmibtn = findViewById(R.id.klmibtn)
        klsebtn = findViewById(R.id.klsebtn)
        srwbackbtn = findViewById(R.id.srwbackbtn)
        srwhomebtn = findViewById(R.id.srwhomebtn)

        klfoodbtn.setOnClickListener {
            val intent = Intent(this, kl_food::class.java)
            startActivity(intent)
        }

        klplacesbtn.setOnClickListener {
            val intent = Intent(this, kl_places::class.java)
            startActivity(intent)
        }

        klmibtn.setOnClickListener {
            val intent = Intent(this, kl_modern_infrastructure::class.java)
            startActivity(intent)
        }

        klsebtn.setOnClickListener {
            val intent = Intent(this, kl_shopping_extravaganza::class.java)
            startActivity(intent)
        }

        srwbackbtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }

        srwhomebtn.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }
    }
}