package com.seleco.camera_recognition_firebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seleco.camera_recognition_firebase.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //1. save topics to database
        //2. change topic you subscribe to
        //maybe save recent one in SharedPreferences
    }
}