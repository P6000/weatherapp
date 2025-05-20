package com.example.myicetask

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class weatherActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val days =
            arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val maxTemps = arrayOf(25, 29, 22, 24, 20, 18, 16)
        val conditions =
            arrayOf("Sunny", "Cloudy", "Rainy", "Sunny", "Partly Cloudy", "Windy", "Clear")

        val weatherInfoLayout: LinearLayout = findViewById(R.id.weatherInfoLayout)
        val averageTempTextView: TextView = findViewById(R.id.averageTempTextView)
        val backButton: Button = findViewById(R.id.backButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        // Display each day with its max temperature
        for (i in days.indices) {
            val dayTempTextView = TextView(this)
            dayTempTextView.text = "${days[i]}: ${maxTemps[i]}°C"
            dayTempTextView.textSize = 18f
            dayTempTextView.setPadding(0, 8, 0, 8)

            dayTempTextView.isClickable = true
            dayTempTextView.isFocusable = true
            dayTempTextView.setBackgroundResource(android.R.drawable.list_selector_background)

            dayTempTextView.setOnClickListener {
                val intent = Intent(this, ConditionActivity::class.java)
                intent.putExtra("EXTRA_DAY", days[i])
                intent.putExtra("EXTRA_CONDITION", conditions[i])
                startActivity(intent)
            }

            weatherInfoLayout.addView(dayTempTextView)
        }

        // Calculate and display average max temperature
        var sumOfTemps = 0
        for (temp in maxTemps) {
            sumOfTemps += temp
        }
        val averageTemp = if (maxTemps.isNotEmpty()) sumOfTemps.toDouble() / maxTemps.size else 0.0
        averageTempTextView.text =
            "Average Max Temperature: ${String.format("%.2f", averageTemp)}°C"

        // Back button to return to previous screen
        backButton.setOnClickListener {
            finish()
        }

        // Next button to go to ConditionsActivity
        nextButton.setOnClickListener {
            val intent = Intent(this, ConditionActivity::class.java)
            intent.putExtra("EXTRA_DAY", "Monday")
            intent.putExtra("EXTRA_CONDITION", "Sunny")
            startActivity(intent)
        }
    }
}