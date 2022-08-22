package com.hellomotem.roxietest.presentation

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observe(): LiveData<Status>

    enum class Status {
        Available, Unavailable
    }
}