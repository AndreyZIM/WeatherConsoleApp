package com.example.presentation

import com.example.domain.WeatherDomain
import com.example.domain.WeatherResult

class WeatherResultMapper(
    private val mapper: WeatherDomain.Mapper<WeatherUI>
) : WeatherResult.Mapper<String> {
    override fun map(result: WeatherDomain?, errorMessage: String): String =
        errorMessage.ifEmpty { result!!.map(mapper).toString() }
}