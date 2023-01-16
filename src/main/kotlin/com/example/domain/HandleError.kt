package com.example.domain

interface HandleError<T> {

    fun handle(e: Exception): T

    class Base : HandleError<String> {
        override fun handle(e: Exception): String = when (e) {
            is NoInternetConnectionException -> "No internet connection!"
            is BadRequestException -> "Bad Request!"
            else -> "Service is unavailable"
        }
    }
}
