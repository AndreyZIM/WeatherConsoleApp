package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherLocation(
    private val name: String,
    private val region: String,
    private val country: String,
    private val lat: Double,
    private val lon: Double,
    private val tz_id: String,
    private val localtime_epoch: Int,
    private val localtime: String
) {
    interface Mapper<T> {
        fun map(
            name: String,
            region: String,
            country: String,
            localtime: String
        ) : T
    }

    fun <T> map(mapper: Mapper<T>) : T = mapper.map(name, region, country, localtime)
}