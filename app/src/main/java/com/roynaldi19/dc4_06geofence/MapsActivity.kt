package com.roynaldi19.dc4_06geofence

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.roynaldi19.dc4_06geofence.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val centerLat = 0.42435
    private val centerLong = 101.43974
    private val geofenceRadius = 400.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map.uiSettings.isZoomControlsEnabled = true

        val kiddHome = LatLng(centerLat, centerLong)
        map.addMarker(MarkerOptions().position(kiddHome).title("Kidd Home"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(kiddHome, 15f))

        map.addCircle(CircleOptions().center(kiddHome).radius(geofenceRadius).fillColor(0x22FF0000).strokeColor(Color.RED).strokeWidth(3f))


    }

}
