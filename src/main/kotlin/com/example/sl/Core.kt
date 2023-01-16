package com.example.sl

import com.example.data.cloudDataSource.CloudModule
import com.example.presentation.DispatchersList
import io.ktor.client.*

interface Core : CloudModule {

    fun provideDispatchers(): DispatchersList

    class Base() : Core {

        private val dispatchersList by lazy {
            DispatchersList.Base()
        }

        private val cloudModule by lazy {
            CloudModule.Base()
        }

        override fun provideDispatchers(): DispatchersList = dispatchersList

        override fun service(): HttpClient = cloudModule.service()
    }

}