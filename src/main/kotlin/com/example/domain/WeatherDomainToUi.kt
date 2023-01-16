package com.example.domain

import com.example.data.model.WeatherCurrent
import com.example.data.model.WeatherData
import com.example.data.model.WeatherLocation
import com.example.presentation.WeatherUI

class WeatherDomainToUi : WeatherDomain.Mapper<WeatherUI> {
    override fun map(
        name: String,
        region: String,
        country: String,
        localtime: String,
        lastUpdated: String,
        tempC: Double,
        isDay: Int,
        windKph: Double,
        windDegree: Int,
        windDir: String,
        pressureMb: Double,
        precipMm: Double,
        humidity: Int,
        cloud: Int,
        feelsLikeC: Double,
        visKm: Double,
        gustKph: Double
    ): WeatherUI = WeatherUI(
        name,
        region,
        country,
        localtime,
        lastUpdated,
        tempC,
        isDay,
        windKph,
        windDegree,
        windDir,
        pressureMb,
        precipMm,
        humidity,
        cloud,
        feelsLikeC,
        visKm,
        gustKph
    )
}