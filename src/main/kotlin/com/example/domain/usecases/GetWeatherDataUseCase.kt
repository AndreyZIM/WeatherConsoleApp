package com.example.domain.usecases

import com.example.domain.WeatherInteractor
import com.example.domain.WeatherResult
import com.example.presentation.WeatherUI

class GetWeatherDataUseCase(private val interactor: WeatherInteractor) {
    suspend fun execute(city: String): WeatherResult = interactor.getWeatherData(city)
}