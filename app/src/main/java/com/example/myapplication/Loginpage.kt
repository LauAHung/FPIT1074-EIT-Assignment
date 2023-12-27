package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.myapplication.databinding.ActivityLoginPageBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Loginpage : AppCompatActivity() {
    lateinit var edtemail_login_input: EditText
    lateinit var edtpass_login_input: EditText
    lateinit var loginbtn: Button
    lateinit var signuptxt: TextView
    lateinit var binding: ActivityLoginPageBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Initialize Firebase components
        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize views
        edtemail_login_input = binding.edtemailLoginInput
        edtpass_login_input = binding.edtpassLoginInput
        loginbtn = binding.loginbtn
        signuptxt = binding.signuptxt


        loginbtn.setOnClickListener {
            if (validateUsername() && validatePassword()) {
                val sanitizedEmail = sanitizeEmail(edtemail_login_input.text.toString().trim())
                checkUser(sanitizedEmail)
            }
        }

        signuptxt.setOnClickListener {
            val intent = Intent(this, signuppagetest::class.java)
            startActivity(intent)
        }
    }

    private fun validateUsername(): Boolean {
        val valUsername = edtemail_login_input.text.toString().trim()
        return if (valUsername.isEmpty()) {
            edtemail_login_input.error = "Username cannot be empty"
            false
        } else {
            edtemail_login_input.error = null
            true
        }
    }

    private fun validatePassword(): Boolean {
        val valPassword = edtpass_login_input.text.toString().trim()
        return if (valPassword.isEmpty()) {
            edtpass_login_input.error = "Password cannot be empty"
            false
        } else {
            edtpass_login_input.error = null
            true
        }
    }

    private fun sanitizeEmail(email: String): String {
        return email.replace(".", "_").replace("@", "_")
    }

    private fun checkUser(sanitizedEmail: String) {
        val userPassword = edtpass_login_input.text.toString().trim()
        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")
        val username = intent.getStringExtra("username")

        reference.child(sanitizedEmail).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val passwordFromDB: String? = snapshot.child("password").getValue(String::class.java)
                    if (passwordFromDB == userPassword) {
                        val emailFromDB: String? = snapshot.child("email").getValue(String::class.java)
                        val usernameFromDB: String? = snapshot.child("username").getValue(String::class.java)
                        val intent = Intent(this@Loginpage, first_menu::class.java)
                        intent.putExtra("email", emailFromDB)
                        intent.putExtra("password", passwordFromDB)
                        intent.putExtra("username", usernameFromDB)
                        startActivity(intent)
                    } else {
                        edtpass_login_input.error = "Invalid Password"
                        edtpass_login_input.requestFocus()
                    }
                } else {
                    edtemail_login_input.error = "User does not exist"
                    edtemail_login_input.requestFocus()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }


}
