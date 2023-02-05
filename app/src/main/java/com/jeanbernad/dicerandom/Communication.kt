package com.jeanbernad.dicerandom

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface Communication<T> {

    fun flow(): StateFlow<T>

    fun map(data: T)

    class Base<T>(data: T): Communication<T> {

        private val state = MutableStateFlow(data)

        override fun flow(): StateFlow<T> = state.asStateFlow()

        override fun map(data: T) {
            state.value = data
        }
    }
}