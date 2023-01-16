package com.example.domain

import com.example.presentation.WeatherUI

interface WeatherInteractor {

    suspend fun getWeatherData(city: String) : WeatherResult

    class Base(
        private val repository: WeatherRepository,
        private val handleRequest: HandleRequest
    ) : WeatherInteractor {

        override suspend fun getWeatherData(city: String): WeatherResult = handleRequest.handle {
            repository.getWeather(city)
        }
    }
}