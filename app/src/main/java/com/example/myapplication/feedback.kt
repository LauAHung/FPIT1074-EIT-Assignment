package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class feedback : AppCompatActivity() {
    lateinit var edtFeedbackInput: EditText
    lateinit var btnFeedbackSubmit: Button
    lateinit var edtFeedbackEmail: EditText
    lateinit var btnFeedbackBack: Button
    lateinit var btnreview: Button
    lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        edtFeedbackInput = findViewById(R.id.edtFeedbackInput)
        edtFeedbackEmail = findViewById(R.id.edtFeedbackEmail)
        btnFeedbackSubmit = findViewById(R.id.btnFeedbackSubmit)
        btnFeedbackBack = findViewById(R.id.btnFeedbackBack)
        btnreview = findViewById(R.id.btnreview)
        myRef = FirebaseDatabase.getInstance().reference

        btnFeedbackSubmit.setOnClickListener {
            var strFBEmail = edtFeedbackEmail.text.toString().trim()
            strFBEmail = sanitizeEmail(strFBEmail)
            var strFB = edtFeedbackInput.text.toString().trim()

            // Get a reference to the feedback node based on the email
            myRef.child("users").child(strFBEmail).child("feedback").setValue(strFB)

            Toast.makeText(this, "Feedback Submitted", Toast.LENGTH_LONG).show()
            edtFeedbackInput.setText("")
            edtFeedbackEmail.setText("")

            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }

        btnFeedbackBack.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }

        btnreview.setOnClickListener {
            val intent = Intent(this, display_feedback::class.java)
            startActivity(intent)
        }


    }
    fun sanitizeEmail(email: String): String {
        return email.replace(".", "_").replace("@", "_")
    }

}