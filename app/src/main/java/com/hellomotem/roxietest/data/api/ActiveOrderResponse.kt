package com.hellomotem.roxietest.data.api

import kotlinx.serialization.Serializable

@Serializable
data class ActiveOrderResponse(
    val id: Int,
    val startAddress: AddressResponse,
    val endAddress: AddressResponse,
    val price: PriceResponse,
    val orderTime: String,
    val vehicle: VehicleResponse
)



