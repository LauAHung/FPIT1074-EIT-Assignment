package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class calendar : AppCompatActivity() {
    lateinit var backbtn: Button
    lateinit var menubtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        menubtn = findViewById(R.id.menubtn)
        backbtn = findViewById(R.id.backbtn)

    }
}