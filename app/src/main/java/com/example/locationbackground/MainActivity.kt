package com.example.locationbackground

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.locationbackground.ui.theme.LocationBackgroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,

            ),
            0
        )

        setContent {
            LocationBackgroundTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Button(onClick = {
                        Intent(applicationContext,LocationService::class.java).apply {
                            action = LocationService.ACTION_START
                            startService(this)
                        }
                    }) {
                        Text(text = "start")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        Intent(applicationContext,LocationService::class.java).apply {
                            action = LocationService.ACTION_STOP
                            startService(this)
                        }
                    }) {
                        Text(text = "stop")
                    }
                }
            }
        }
    }
}
