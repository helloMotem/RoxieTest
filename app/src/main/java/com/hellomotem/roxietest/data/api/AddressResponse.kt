package com.hellomotem.roxietest.data.api

import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    val city: String,
    val address: String
)