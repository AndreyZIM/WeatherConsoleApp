package com.example.presentation

import com.example.data.BaseWeatherRepository
import com.example.data.HandleDataError
import com.example.data.HandleDataRequest
import com.example.data.WeatherDataToDomain
import com.example.data.cloudDataSource.CloudDataSource
import com.example.domain.HandleError
import com.example.domain.HandleRequest
import com.example.domain.WeatherDomainToUi
import com.example.domain.WeatherInteractor
import com.example.domain.usecases.GetWeatherDataUseCase
import com.example.sl.Core
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.lang.StringBuilder

suspend fun main(args: Array<String>) {

    val validator = InputValidation()

    val method: String = validator.inputMethod()
    val argument = validator.inputArgument(method)

    val core = Core.Base()
    val handleWeatherRequest =
        HandleWeatherRequest.Base(
            core.provideDispatchers(),
            WeatherResultMapper(WeatherDomainToUi())
        )

    val interactor = WeatherInteractor.Base(
        BaseWeatherRepository(
            CloudDataSource.Base(core.service()),
            HandleDataRequest.Base(
                WeatherDataToDomain(),
                HandleDataError()
            )
        ),
        HandleRequest.Base(
            HandleError.Base()
        )
    )
    val useCase = GetWeatherDataUseCase(interactor)

    val scope = CoroutineScope(SupervisorJob())
    val differed = handleWeatherRequest.handle(scope) {
        useCase.execute(argument)
    }
    val weather = differed.await()

    println(weather)
}