package com.example.clock2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private lateinit var bckbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actvt2)
        init()
    }
    private fun init(){
        bckbtn = findViewById(R.id.btn_back)
        with(bckbtn){
            setOnClickListener { back() }
        }
    }
         fun back(){
        val bck_intent = Intent(this,MainActivity::class.java)
        startActivity(bck_intent)
    }
}