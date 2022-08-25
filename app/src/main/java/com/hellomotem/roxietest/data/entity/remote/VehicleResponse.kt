package com.hellomotem.roxietest.data.entity.remote

import kotlinx.serialization.Serializable

@Serializable
data class VehicleResponse(
    //@SerializedName("regNumber")
    val regNumber: String,
    //@SerializedName("modelName")
    val modelName: String,
    //@SerializedName("photo")
    val photo: String,
    //@SerializedName("driverName")
    val driverName: String
)