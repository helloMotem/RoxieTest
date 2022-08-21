package com.hellomotem.roxietest.data.mapper

import com.hellomotem.roxietest.data.api.CarImageResponse
import com.hellomotem.roxietest.domain.entity.CarImage

class CarImageResponseMapper : Mapper<CarImageResponse, CarImage> {
    override fun map(data: CarImageResponse): CarImage = CarImage(
        id = data.id,
        path = data.path
    )
}