package com.hellomotem.roxietest.data.entity.remote

import kotlinx.serialization.Serializable

@Serializable
data class ActiveOrderResponse(
    //@SerializedName("id")
    val id: Int,
   // @SerializedName("startAddress")
    val startAddress: AddressResponse,
    //@SerializedName("endAddress")
    val endAddress: AddressResponse,
    //@SerializedName("price")
    val price: PriceResponse,
    //@SerializedName("orderTime")
    val orderTime: String,
    //@SerializedName("vehicle")
    val vehicle: VehicleResponse
)



