package com.seleco.camera_recognition_firebase.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.seleco.camera_recognition_firebase.R

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var loginButton:Button
    private lateinit var passwordInput:TextView
    private lateinit var emailInput:TextView
    private lateinit var registerButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        loginButton = findViewById(R.id.loginBtn)
        emailInput = findViewById(R.id.email_text_input)
        passwordInput = findViewById(R.id.password_text_input)
        registerButton = findViewById(R.id.register_btn)

        mAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            signInWithEmailAndPassword(email, password)
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //we can now get some info about user
                    val user = mAuth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Log.w("LoginActivity", "signInWithEmailAndPassword:failure", task.exception)
                    Toast.makeText(this, "Autentykacja nie powiodła się.", Toast.LENGTH_SHORT).show()
                }
            }
    }
    //to logout
    //Firebase.auth.signOut()
}