package com.hellomotem.roxietest.data.api

import kotlinx.serialization.Serializable

@Serializable
data class VehicleResponse(
    val regNumber: String,
    val modelName: String,
    val photo: String,
    val driverName: String
)