package com.example.clock2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mUpdateButton: Button
    private lateinit var mActvtBtn: Button
    private lateinit var mRelativeButton: Button
    private lateinit var mScrollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        updateUI()
    }

    private fun initViews() {
        mScrollButton = findViewById(R.id.scrl_btn)
        with(mScrollButton) {
            setOnClickListener { openScrollViewActivity() }
        }
        mRelativeButton = findViewById(R.id.rlative_btn)
        with(mRelativeButton) {
            setOnClickListener { openRelativeActivity() }
        }
        mUpdateButton = findViewById(R.id.btn_update)
        with(mUpdateButton) {
            setOnClickListener { updateUI() }
        }
        mActvtBtn = findViewById(R.id.actvt)
        with(mActvtBtn) {
            setOnClickListener { openSecondActivity() }
        }
    }

    private fun getCurrentTime(): String {
        val timestamp = System.currentTimeMillis()
        return convertMillisToTime(timestamp, PATTERN_HOUR_MINUTE_SECOND)
    }

    private fun updateUI() {
        tv_current_time.text = getCurrentTime()
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