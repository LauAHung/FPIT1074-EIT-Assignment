package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDisplayFeedbackBinding
import com.google.firebase.database.*

class display_feedback : AppCompatActivity() {
    lateinit var txtFeedback1: TextView
    lateinit var txtFeedback2: TextView
    lateinit var txtFeedback3: TextView
    lateinit var txtFeedback4: TextView
    lateinit var txtFeedback5: TextView
    lateinit var txtFeedback6: TextView
    lateinit var txtFeedback7: TextView
    lateinit var txtFeedback8: TextView
    lateinit var txtFeedback9: TextView
    lateinit var txtFeedback10: TextView
    lateinit var btndisplayback: Button

    private lateinit var myRef: DatabaseReference

    private lateinit var binding: ActivityDisplayFeedbackBinding
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtFeedback1 = findViewById(R.id.txtFeedback1)
        txtFeedback2 = findViewById(R.id.txtFeedback2)
        txtFeedback3 = findViewById(R.id.txtFeedback3)
        txtFeedback4 = findViewById(R.id.txtFeedback4)
        txtFeedback5 = findViewById(R.id.txtFeedback5)
        txtFeedback6 = findViewById(R.id.txtFeedback6)
        txtFeedback7 = findViewById(R.id.txtFeedback7)
        txtFeedback8 = findViewById(R.id.txtFeedback8)
        txtFeedback9 = findViewById(R.id.txtFeedback9)
        txtFeedback10 = findViewById(R.id.txtFeedback10)
        btndisplayback = findViewById(R.id.btndisplayback)

        database = FirebaseDatabase.getInstance()
        myRef = FirebaseDatabase.getInstance().reference

        val txtCollection = mutableListOf(
            // here put in your textviews name, each one by one, like:
            txtFeedback1,
            txtFeedback2,
            txtFeedback3,
            txtFeedback4,
            txtFeedback5,
            txtFeedback6,
            txtFeedback7,
            txtFeedback8,
            txtFeedback9,
            txtFeedback10
        )


        for (txtView in txtCollection) {
            txtView.visibility = View.GONE
        }

        val myRef = FirebaseDatabase.getInstance().reference
        val getData = object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var counter = 0
                for (user in snapshot.child("users").children) {
                    val txtView = txtCollection[counter]
                    //val strEmail = user.child("email").value.toString().trim()
                    val strUsername = user.child("username").value.toString().trim()
                    val strFeedback = user.child("feedback").value.toString().trim()
                    txtView.text =
                        "Username: $strUsername\nFeedback: $strFeedback"
                    txtView.visibility = View.VISIBLE
                    counter++
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }

        myRef.addValueEventListener(getData)

        btndisplayback.setOnClickListener {
            val intent = Intent(this, first_menu::class.java)
            startActivity(intent)
        }
    }
}




