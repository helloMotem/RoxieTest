package com.hellomotem.roxietest.domain.entity

import okhttp3.ResponseBody
import java.io.InputStream

sealed interface CarImage {
    data class LocalCarImage(
        val image: InputStream
    ) : CarImage

    data class ApiCarImage(
        val image: ResponseBody
    ) : CarImage
}
