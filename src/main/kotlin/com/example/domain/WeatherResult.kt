package com.example.domain

sealed class WeatherResult {

    interface Mapper<T> {
        fun map(result: WeatherDomain?, errorMessage: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val result: WeatherDomain? = null) : WeatherResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(result, "")
    }

    data class Failure(private val message: String) : WeatherResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(null, message)
    }
}
