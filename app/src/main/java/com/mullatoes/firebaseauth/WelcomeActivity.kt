package com.mullatoes.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class WelcomeActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        auth = Firebase.auth

        loginButton = findViewById(R.id.login_button_welcome)
        registerButton = findViewById(R.id.register_button_welcome)

        loginButton.setOnClickListener {
            val intent = Intent(
                this,
                LoginActivity::class.java
            )

            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val intent = Intent(
                this,
                RegisterActivity::class.java
            )

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(
                this,
                LoginActivity::class.java
            )

            startActivity(intent)
        }else{
            val intent = Intent(
                this,
                WelcomeActivity::class.java
            )

            startActivity(intent)
        }
    }
}