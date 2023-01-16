package com.example.data

import com.example.data.model.WeatherCurrent
import com.example.data.model.WeatherData
import com.example.data.model.WeatherLocation
import com.example.domain.WeatherDomain

class WeatherDataToDomain : WeatherData.Mapper<WeatherDomain> {

    override fun map(location: WeatherLocation, current: WeatherCurrent): WeatherDomain {
        val wLocation = location.map(LocationMapper())
        val wCurrent = current.map(CurrentMapper())
        return WeatherDomain(
            wLocation.name!!,
            wLocation.region!!,
            wLocation.country!!,
            wLocation.localtime!!,
            wCurrent.lastUpdated!!,
            wCurrent.tempC!!,
            wCurrent.isDay!!,
            wCurrent.windKph!!,
            wCurrent.windDegree!!,
            wCurrent.windDir!!,
            wCurrent.pressureMb!!,
            wCurrent.precipMm!!,
            wCurrent.humidity!!,
            wCurrent.cloud!!,
            wCurrent.feelsLikeC!!,
            wCurrent.visKm!!,
            wCurrent.gustKph!!
        )
    }

    private data class NullableWeatherDomain(
        val name: String?,
        val region: String?,
        val country: String?,
        val localtime: String?,
        val lastUpdated: String?,
        val tempC: Double?,
        val isDay: Int?,
        val windKph: Double?,
        val windDegree: Int?,
        val windDir: String?,
        val pressureMb: Double?,
        val precipMm: Double?,
        val humidity: Int?,
        val cloud: Int?,
        val feelsLikeC: Double?,
        val visKm: Double?,
        val gustKph: Double?
    )

    private class LocationMapper : WeatherLocation.Mapper<NullableWeatherDomain> {
        override fun map(name: String, region: String, country: String, localtime: String): NullableWeatherDomain =
            NullableWeatherDomain(
                name,
                region,
                country,
                localtime,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
    }

    private class CurrentMapper : WeatherCurrent.Mapper<NullableWeatherDomain> {
        override fun map(
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
        ): NullableWeatherDomain = NullableWeatherDomain(
            null,
            null,
            null,
            null,
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
}