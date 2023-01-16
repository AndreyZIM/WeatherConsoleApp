package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherData(
    private val location: WeatherLocation,
    private val current: WeatherCurrent
) {
    interface Mapper<T> {
        fun map(location: WeatherLocation, current: WeatherCurrent): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(location, current)
}
