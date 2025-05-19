package com.example.myicetask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class weatherActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val maxTemps = arrayOf(25, 29, 22, 24, 20, 18, 16)

        val weatherInfoLayout: LinearLayout = findViewById(R.id.weatherInfoLayout)
        val averageTempTextView: TextView = findViewById(R.id.averageTempTextView)
        val backButton: Button = findViewById(R.id.backButton)

        // Display each day with its max temperature using a loop
        for (i in days.indices) {
            val dayTextView = TextView(this)
            dayTextView.text = "${days[i]}: ${maxTemps[i]}°C"
            dayTextView.textSize = 18f
            weatherInfoLayout.addView(dayTextView)
        }

        // Calculate and show the average max temperature using a loop
        var sumOfTemps = 0
        for (temp in maxTemps) {
            sumOfTemps += temp
        }
        val averageTemp = if (maxTemps.isNotEmpty()) sumOfTemps.toDouble() / maxTemps.size else 0.0
        averageTempTextView.text = "Average Max Temperature: ${String.format("%.2f", averageTemp)}°C"

        // Set up the Back button
        backButton.setOnClickListener {
            finish() // This will navigate back to the previous activity (MainActivity)
        }
    }
}