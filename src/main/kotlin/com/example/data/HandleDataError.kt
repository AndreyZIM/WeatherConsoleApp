package com.example.data

import com.example.domain.BadRequestException
import com.example.domain.HandleError
import com.example.domain.NoInternetConnectionException
import com.example.domain.ServiceUnavailableException
import io.ktor.serialization.*
import java.nio.channels.UnresolvedAddressException

class HandleDataError: HandleError<Exception> {

    override fun handle(e: Exception): Exception = when (e) {
        is UnresolvedAddressException -> NoInternetConnectionException()
        is JsonConvertException -> BadRequestException()
        else -> ServiceUnavailableException()
    }
}
