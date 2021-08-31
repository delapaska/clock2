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
            with(scrlBtn) {
                setOnClickListener { openScrollViewActivity() }
            }
            with(rlativeBtn) {
                setOnClickListener { openRelativeActivity() }
            }
            with(btnUpdate) {
                setOnClickListener { updateUI() }
            }
            with(actvt) {
                setOnClickListener { openSecondActivity() }
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

    private fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    private fun openRelativeActivity() {
        val intent = Intent(this, RelativeLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun openScrollViewActivity() {
        val intent = Intent(this, ScrollViewActivity::class.java)
        startActivity(intent)
    }
}