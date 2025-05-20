package com.example.myicetask

import org.junit.Test
import org.junit.Assert.*

class UnitTest {

    private val days =
        arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val maxTemps = arrayOf(25, 29, 22, 24, 20, 18, 16)
    private val conditions =
        arrayOf("Sunny", "Cloudy", "Rainy", "Sunny", "Rainy", "Cloudy", "Sunny")

    @Test
    fun testAverageTemperature() {
        val expectedAverage = maxTemps.sum() / maxTemps.size
        val actualAverage = calculateAverage(maxTemps)
        assertEquals(expectedAverage, actualAverage)
    }

    @Test
    fun testParallelArraysAreAligned() {
        assertEquals(days.size, maxTemps.size)
        assertEquals(maxTemps.size, conditions.size)
    }

    private fun calculateAverage(temps: Array<Int>): Int {
        var sum = 0
        for (temp in temps) {
            sum += temp
        }
        return sum / temps.size
    }
}
