package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherCondition(
    private val text: String,
    private val icon: String,
    private val code: Int
)
