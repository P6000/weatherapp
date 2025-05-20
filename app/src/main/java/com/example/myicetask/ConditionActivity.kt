package com.example.myicetask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConditionActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condition)

        val dayTextView: TextView = findViewById(R.id.dayTextViewCondition)
        val conditionTextView: TextView = findViewById(R.id.conditionTextView)
        val backButton: Button = findViewById(R.id.backButtonCondition)

        // --- Get data passed from WeatherActivity (if any) ---
        val day = intent.getStringExtra("EXTRA_DAY")
        val condition = intent.getStringExtra("EXTRA_CONDITION")

        dayTextView.text = day ?: "Selected Day"
        conditionTextView.text = "Condition: ${condition ?: "N/A"}"

        backButton.setOnClickListener {
            finish()
        }
    }
}