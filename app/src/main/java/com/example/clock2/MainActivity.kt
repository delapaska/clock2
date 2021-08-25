package com.example.clock2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mUpdateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        updateUI()
    }

    private fun initViews() {
        mUpdateButton = findViewById(R.id.btn_update)
        with(mUpdateButton) {
            setOnClickListener { updateUI() }
        }
    }

    private fun getCurrentTime() : String {
        val timestamp = System.currentTimeMillis()
        return convertMillisToTime(timestamp, PATTERN_HOUR_MINUTE_SECOND)
    }

    private fun updateUI() {
        textView3.text = getCurrentTime()
    }
}