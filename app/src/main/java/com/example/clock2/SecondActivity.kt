package com.example.clock2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }

    private fun init() {
        backButton = findViewById(R.id.btn_back)
        with(backButton) {
            setOnClickListener { goBack() }
        }
    }

    private fun goBack() {
        onBackPressed()
    }
}