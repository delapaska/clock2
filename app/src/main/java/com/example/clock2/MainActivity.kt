package com.example.clock2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mUpdateButton: Button
    private lateinit var mActvtBtn:Button
    private lateinit var mRltiveBtn:Button
    private lateinit var mScrlBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        updateUI()
    }

    private fun initViews() {
        mScrlBtn = findViewById(R.id.scrl_btn)
        with(mScrlBtn){
            setOnClickListener { Scrl() }
        }
        mRltiveBtn = findViewById(R.id.rlative_btn)
        with(mRltiveBtn){
            setOnClickListener {Rlative()  }
        }
        mUpdateButton = findViewById(R.id.btn_update)
        with(mUpdateButton) {
            setOnClickListener { updateUI() }
        }
        mActvtBtn =findViewById(R.id.actvt)
        with(mActvtBtn){
            setOnClickListener { actvtbtn() }
        }
    }

    private fun getCurrentTime() : String {
        val timestamp = System.currentTimeMillis()
        return convertMillisToTime(timestamp, PATTERN_HOUR_MINUTE_SECOND)
    }

    private fun updateUI() {
        tv_current_time.text = getCurrentTime()
    }
   private fun actvtbtn(){
                val intent = Intent(this,actvt2::class.java)
                startActivity(intent)
    }
    fun Rlative(){
        val intent = Intent(this,Relative::class.java)
        startActivity(intent)
    }
    private fun Scrl(){
        val intent = Intent(this,Scroll::class.java)
        startActivity(intent)
    }
}