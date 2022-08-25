package com.hellomotem.roxietest.data.entity.remote

import kotlinx.serialization.Serializable

@Serializable
data class PriceResponse(
    //@SerializedName("amount")
    val amount: Long,
    //@SerializedName("currency")
    val currency: String
)