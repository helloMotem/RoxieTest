package com.hellomotem.roxietest.data.api

import com.google.gson.annotations.SerializedName

data class ActiveOrderResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("startAddress") val startAddress: AddressResponse,
    @SerializedName("endAddress") val endAddress: AddressResponse,
    @SerializedName("price") val price: PriceResponse,
    @SerializedName("orderTime") val orderTime: String,
    @SerializedName("vehicle") val vehicle: VehicleResponse
)

data class AddressResponse(
    @SerializedName("city") val city: String,
    @SerializedName("address") val address: String
)

data class PriceResponse(
    @SerializedName("amount") val amount: Long,
    @SerializedName("currency") val currency: String
)

data class VehicleResponse(
    @SerializedName("regNumber") val regNumber: String,
    @SerializedName("modelName") val modelName: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("driverName") val driverName: String
)