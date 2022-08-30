package com.hellomotem.roxietest.domain.repository

import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage
import okhttp3.ResponseBody
import java.io.File

interface OrdersRepository {

    suspend fun fetchActiveOrders(): List<ActiveOrder>?

    suspend fun fetchCarImage(imageName: String): CarImage

    suspend fun getLocalCarImage(name: String): CarImage?

    suspend fun saveCarImage(name: String, carImage: CarImage)

    suspend fun deleteCarImage(name: String): Boolean
}