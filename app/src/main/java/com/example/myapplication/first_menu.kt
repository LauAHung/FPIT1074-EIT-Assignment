package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class first_menu : AppCompatActivity() {
    lateinit var ebutton: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button2: Button
    lateinit var imageView: ImageView
    lateinit var imageView4: ImageView
    lateinit var imageView0: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_menu)
        ebutton = findViewById(R.id.ebutton)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button2 = findViewById(R.id.button2)
        imageView = findViewById(R.id.imageView)
        imageView4 = findViewById(R.id.imageView4)
        imageView0 = findViewById(R.id.imageView0)


        val email = intent.getStringExtra("email")
        val username = intent.getStringExtra("username")

        val welcomeTextView: TextView = findViewById(R.id.welcomeTextView)
        welcomeTextView.text = "Welcome, $username!"


        ebutton.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, feedback::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "Successful logout", Toast.LENGTH_SHORT).show();
        }

        button2.setOnClickListener {
            val intent = Intent(this, calendar::class.java)
            startActivity(intent)
        }

        imageView.setOnClickListener {
            val intent = Intent(this, PenangFood::class.java)
            startActivity(intent)
        }

        imageView4.setOnClickListener {
            val intent = Intent(this, kl_shopping_extravaganza::class.java)
            startActivity(intent)
        }

        imageView0.setOnClickListener {
            val intent = Intent(this, SarawakPlaces::class.java)
            startActivity(intent)
        }


    }
}