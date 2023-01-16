package com.example.domain

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherDomain
}