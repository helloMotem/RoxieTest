package com.hellomotem.roxietest.domain.repository

import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage

interface Repository {

    suspend fun fetchActiveOrders(): Result<List<ActiveOrder>>

    suspend fun fetchCarImage(imageName: String): Result<CarImage>

    fun getLocalCarImage(): Result<CarImage>
}