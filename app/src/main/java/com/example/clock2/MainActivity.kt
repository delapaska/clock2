package com.example.clock2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clock2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        updateUI()
    }

    private fun initViews() {
        with(binding) {
            with(btnUpdate) {
                setOnClickListener { updateUI() }
            }
            with(gpsButton) {
                setOnClickListener { openGpsActivity() }
            }
        }
    }

    private fun getCurrentTime(): String {
        val timestamp = System.currentTimeMillis()
        return convertMillisToTime(timestamp, PATTERN_HOUR_MINUTE_SECOND)
    }

    private fun updateUI() {
        binding.tvCurrentTime.text = getCurrentTime()
    }

    private fun openGpsActivity() {
        val intent = Intent(this, GpsCoordActivity::class.java)
        startActivity(intent)
    }


}