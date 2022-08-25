package com.hellomotem.roxietest.data.entity.remote

import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    //@SerializedName("city")
    val city: String,
    //@SerializedName("address")
    val address: String
)