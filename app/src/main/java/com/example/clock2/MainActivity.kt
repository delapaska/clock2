package com.example.clock2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var date= DateTimeFormatter.ofPattern("HH:mm:ss")
        var time= LocalDateTime.now()
        var date_time= date.format(time)

        textView3.text = date_time.toString()
    }



    fun btnClick(view: View){

        var date1 = DateTimeFormatter.ofPattern("HH:mm:ss")
        var now= LocalDateTime.now()
        var time1 = date1.format(now)

        textView3.text = time1.toString()





    }

}