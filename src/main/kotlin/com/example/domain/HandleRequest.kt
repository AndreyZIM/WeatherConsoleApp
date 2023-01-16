package com.example.domain

import com.example.presentation.WeatherUI

interface HandleRequest {

    suspend fun handle(block: suspend () -> WeatherDomain) : WeatherResult

    class Base(
        private val handleError: HandleError<String>,
    ) : HandleRequest {
        override suspend fun handle(block: suspend () -> WeatherDomain): WeatherResult = try {
            val result = block.invoke()
            WeatherResult.Success(result)
        } catch (e: Exception) {
            WeatherResult.Failure(handleError.handle(e))
        }

    }

}
