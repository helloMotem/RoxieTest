package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.domain.entity.CarImage

interface LocalDataSource {

    fun getCarImage(): CarImage?
}