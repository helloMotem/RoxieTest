package com.hellomotem.roxietest.presentation.mapper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.hellomotem.roxietest.domain.entity.CarImage

class CarImageUiMapper : Mapper<CarImage, Bitmap?> {
    override fun map(data: CarImage): Bitmap? {
        return when (data) {
            is CarImage.ApiCarImage -> BitmapFactory.decodeStream(data.image.byteStream())
            is CarImage.LocalCarImage -> BitmapFactory.decodeStream(data.image)
        }
    }
}