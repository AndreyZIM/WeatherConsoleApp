package com.example.presentation

import kotlinx.serialization.Serializable

@Serializable
data class WeatherUI(
    private val name: String,
    private val region: String,
    private val country: String,
    private val localtime: String,
    private val lastUpdated: String,
    private val tempC: Double,
    private val isDay: Int,
    private val windKph: Double,
    private val windDegree: Int,
    private val windDir: String,
    private val pressureMb: Double,
    private val precipMm: Double,
    private val humidity: Int,
    private val cloud: Int,
    private val feelsLikeC: Double,
    private val visKm: Double,
    private val gustKph: Double
) {
    override fun toString(): String {
        return """
            ***** Last update - $lastUpdated ***** 
            -----------------LOCATION-----------------
            | City           | $name
            | Region         | $region
            | Country        | $country
            | Local Time     | $localtime
            -----------------CONDITION----------------
            | Temperature    | $tempC °C
            | Feels like     | $feelsLikeC °C
            | Wind Speed     | $windKph km\h
            | Wind Degree    | $windDegree'
            | Wind Direction | $windDir
            | Pressure       | $pressureMb mb
            | Precip         | $precipMm mm
            | Humidity       | $humidity%
            | Cloud          | $cloud%
            | Visibility     | $visKm km
            | Gust           | $gustKph km\h
            ------------------------------------------
        """.trimIndent()
    }
}
