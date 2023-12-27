package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.myapplication.databinding.ActivitySignuppagetestBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class signuppagetest : AppCompatActivity() {
    lateinit var username_input: AppCompatEditText
    lateinit var edtemail_input: AppCompatEditText
    lateinit var edtpass_input: AppCompatEditText
    lateinit var edtcpass_input: AppCompatEditText
    lateinit var signupbtn: Button
    lateinit var logintxt: TextView
    lateinit var binding: ActivitySignuppagetestBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppagetest)

        // Initialize Firebase components
        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        binding = ActivitySignuppagetestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize views
        username_input = findViewById(R.id.username_input)
        edtemail_input = findViewById(R.id.edtemail_input)
        edtpass_input = findViewById(R.id.edtpass_input)
        edtcpass_input = findViewById(R.id.edtcpass_input)
        signupbtn = findViewById(R.id.signupbtn)
        logintxt = findViewById(R.id.logintxt)

        logintxt.setOnClickListener {
            val intent = Intent(this, Loginpage::class.java)
            startActivity(intent)
        }

        binding.signupbtn.setOnClickListener {
            database = FirebaseDatabase.getInstance()
            reference = database.getReference("users")

            val username = binding.usernameInput.text.toString()
            val email = binding.edtemailInput.text.toString()
            val password = binding.edtpassInput.text.toString()
            val confirmPassword = binding.edtcpassInput.text.toString()

            if (email.contains(".") || email.contains("@")) {
                // Sanitize the email address to create a valid Firebase Database key
                val sanitizedEmail = email.replace(".", "_").replace("@", "_")

                val helperClass = HelperClass(username, email, password)
                reference.child(sanitizedEmail).setValue(helperClass)

                if (username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                    if (password == confirmPassword) {
                        Toast.makeText(this, "You have signed up successfully!", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this, Loginpage::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Empty Fields Are not Allowed !", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, "Invalid Email Format!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
