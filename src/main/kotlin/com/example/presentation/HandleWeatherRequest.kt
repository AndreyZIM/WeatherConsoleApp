package com.example.presentation

import com.example.domain.WeatherResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

interface HandleWeatherRequest {

    fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> WeatherResult
    ): Deferred<String>

    class Base(
        private val dispatchers: DispatchersList,
        private val mapper: WeatherResult.Mapper<String>
    ) : HandleWeatherRequest {
        override fun handle(coroutineScope: CoroutineScope, block: suspend () -> WeatherResult) =
            coroutineScope.async(dispatchers.io()) {
                val result = block.invoke()
                result.map(mapper)
            }

    }
}