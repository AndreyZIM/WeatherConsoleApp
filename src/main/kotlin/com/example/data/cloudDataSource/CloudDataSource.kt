package com.example.data.cloudDataSource

import com.example.data.model.WeatherData
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

interface CloudDataSource {

    suspend fun fetchData(city: String): WeatherData

    class Base(private val client: HttpClient) : CloudDataSource {

        override suspend fun fetchData(city: String): WeatherData {
            val response = client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = "api.weatherapi.com"
                    path("v1/current.json")
                    parameter("key", "dacf7e2b21e74ebdb6b125956231001")
                    parameter("q", city)
                    parameter("aqi", "no")
                }
            }
            return response.body()
        }
    }
}
