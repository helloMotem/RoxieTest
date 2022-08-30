package com.hellomotem.roxietest.data.api

import kotlinx.serialization.Serializable

@Serializable
data class PriceResponse(
    val amount: Long,
    val currency: String
)