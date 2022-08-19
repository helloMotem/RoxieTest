package com.hellomotem.roxietest.data.entity

import com.google.gson.annotations.SerializedName

data class ActiveOrderResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("startAddress") val startAddress: Address,
    @SerializedName("endAddress") val endAddress: Address,
    @SerializedName("price") val price: Price,
    @SerializedName("orderTime") val orderTime: String,
    @SerializedName("vehicle") val vehicle: Vehicle
)

data class Address(
    @SerializedName("city") val city: String,
    @SerializedName("address") val address: String
)

data class Price(
    @SerializedName("amount") val amount: Long,
    @SerializedName("currency") val currency: String
)

data class Vehicle(
    @SerializedName("regNumber") val regNumber: String,
    @SerializedName("modelName") val modelName: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("driverName") val driverName: String
)