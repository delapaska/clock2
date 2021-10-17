package com.example.clock2

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.clock2.databinding.ActivityMainBinding
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.activity_gps.*

class GpsCoordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var backButton: Button
    private lateinit var getLocationButton: Button
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        findViewById<TextView>(R.id.latitudeView)



        init()
    }

    private fun init() {
        backButton = findViewById(R.id.btn_back)
        getLocationButton = findViewById(R.id.getLastLocBtn)
        with(getLocationButton){
            setOnClickListener { getLastKnownLocation() }
        }
        with(backButton) {
            setOnClickListener { goBack() }
        }
    }
    private fun goBack() {
        onBackPressed()
    }

  fun getLastKnownLocation() {
        val task= fusedLocationClient.lastLocation
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
            .checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)
            return
        }
        task.addOnSuccessListener {
            if(it!=null) {
                Toast.makeText(applicationContext,"${it.latitude} ${it.longitude}",Toast.LENGTH_SHORT).show()
                latitudeView.text = "Latitude: " + it.latitude.toString()
                longitudeView.text = "Longitude: " + it.longitude.toString()
            }
        }



        }


    }
