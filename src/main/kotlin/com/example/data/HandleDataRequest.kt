package com.example.data

import com.example.data.model.WeatherData
import com.example.domain.WeatherDomain

interface HandleDataRequest {

    suspend fun handle(block: suspend () -> WeatherData): WeatherDomain

    class Base(
        private val mapper: WeatherDataToDomain,
        private val handleError: HandleDataError
    ) : HandleDataRequest {
        override suspend fun handle(block: suspend () -> WeatherData): WeatherDomain {
            try {
                val result = block.invoke()
                return result.map(mapper)
            } catch (e: Exception) {
                throw handleError.handle(e)
            }
        }
    }
}