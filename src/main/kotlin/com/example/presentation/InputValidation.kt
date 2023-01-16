package com.example.presentation

import java.lang.StringBuilder

class InputValidation {

    fun inputMethod(): String {
        var method: String
        print(
            """
            Выберите метод ввода:
            1 - Координаты
            2 - Название города
            
        """.trimIndent()
        )
        try {
            method = readlnOrNull()!!
            method.toInt()
            if (method.toInt() != 1 && method.toInt() != 2) throw IllegalArgumentException()
        } catch (e: Exception) {
            println("Неверный ввод!")
            method = inputMethod()
        }
        return method
    }

    fun inputArgument(method: String) : String {
        val latitude: Double
        val longitude: Double
        var result = StringBuilder()
        var argument: String
        if (method == "1") {
            try {
                println("Введите долготу: ")
                latitude = readlnOrNull()!!.toDouble()
                println("Введите широту: ")
                longitude = readlnOrNull()!!.toDouble()
                result.append(latitude)
                result.append(",")
                result.append(longitude)
                argument = result.toString()
            } catch (e: Exception) {
                println("Неверный ввод!")
                argument = inputArgument(method)
            }
        } else {
            argument = try {
                println("Введите название города: ")
                result.append(readlnOrNull()!!)
                result.toString()
            } catch (e: Exception) {
                println("Неверный ввод!")
                inputArgument(method)
            }
        }
        return argument

    }
}