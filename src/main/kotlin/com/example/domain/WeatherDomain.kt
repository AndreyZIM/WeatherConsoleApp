package com.example.domain

data class WeatherDomain(
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
    interface Mapper<T> {
        fun map(
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
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
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
