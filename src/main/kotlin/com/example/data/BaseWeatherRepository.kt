package com.example.data

import com.example.data.cloudDataSource.CloudDataSource
import com.example.domain.WeatherDomain
import com.example.domain.WeatherRepository

class BaseWeatherRepository(
    private val cloudDataSource: CloudDataSource,
    private val handleRequest: HandleDataRequest
    ) : WeatherRepository {

    override suspend fun getWeather(city: String): WeatherDomain = handleRequest.handle {
        cloudDataSource.fetchData(city)
    }
}