package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class signuppage : AppCompatActivity() {
    private lateinit var surnameInput: TextInputEditText
    private lateinit var firstnameInput: TextInputEditText
    private lateinit var edtemail: TextInputEditText
    private lateinit var edtpass: TextInputEditText
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var signupbtn: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppage)

        auth = Firebase.auth

        val registerButton: Button = findViewById(R.id.signupbtn)

        registerButton.setOnClickListener {
            performSignup()
        }

        //lets get email and password for the user


    }

    private fun performSignup() {
        val email = findViewById<EditText>(R.id.edtemail)
        val password = findViewById<EditText>(R.id.edtpass)

        if (email.text.isEmpty() && password.text.isEmpty() ){
            Toast.makeText(this, "please fill all flieds", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, let move to the next activity

                    val intent = Intent(this, MenuPage::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        baseContext,
                        "Success.",
                        Toast.LENGTH_SHORT,
                    ).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }
            .addOnFailureListener{
                Toast.makeText(this, "Error ${it.localizedMessage}", Toast.LENGTH_SHORT)
                    .show()
            }



    }


}