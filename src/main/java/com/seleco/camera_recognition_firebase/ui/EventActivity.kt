package com.seleco.camera_recognition_firebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.seleco.camera_recognition_firebase.R

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val webView: WebView = findViewById(R.id.web_view)
        val url: String? = intent.getStringExtra("url")

        webView.loadUrl(url?:"www.google.com")
    }
}