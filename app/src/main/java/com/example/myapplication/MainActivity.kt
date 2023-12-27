package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var startbtn: Button
    lateinit var feedback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startbtn = findViewById(R.id.startbtn)

        startbtn.setOnClickListener {
            val intent = Intent(this, Loginpage::class.java)
            startActivity(intent)
        }

    }

}