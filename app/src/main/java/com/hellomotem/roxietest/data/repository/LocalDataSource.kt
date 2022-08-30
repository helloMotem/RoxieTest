package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.domain.entity.CarImage
import okhttp3.ResponseBody
import java.io.File

interface LocalDataSource {

    suspend fun getCarImage(name: String): CarImage?

    suspend fun saveCarImage(name: String, content: CarImage)

    suspend fun deleteCarImage(name: String): Boolean
}