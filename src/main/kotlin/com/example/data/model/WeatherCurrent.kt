package com.example.data.model

import com.example.domain.WeatherDomain
import kotlinx.serialization.Serializable

@Serializable
data class WeatherCurrent(
    private val last_updated_epoch:Int,
    private val last_updated:String,
    private val temp_c:Double,
    private val temp_f:Double,
    private val is_day:Int,
    private val condition: WeatherCondition,
    private val wind_mph:Double,
    private val wind_kph:Double,
    private val wind_degree:Int,
    private val wind_dir:String,
    private val pressure_mb:Double,
    private val pressure_in:Double,
    private val precip_mm:Double,
    private val precip_in:Double,
    private val humidity:Int,
    private val cloud:Int,
    private val feelslike_c:Double,
    private val feelslike_f:Double,
    private val vis_km:Double,
    private val vis_miles:Double,
    private val uv:Double,
    private val gust_mph:Double,
    private val gust_kph:Double
) {
    interface Mapper<T> {
        fun map(
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
        last_updated,
        temp_c,
        is_day,
        wind_kph,
        wind_degree,
        wind_dir,
        pressure_mb,
        precip_mm,
        humidity,
        cloud,
        feelslike_c,
        vis_km,
        gust_kph
    )
}