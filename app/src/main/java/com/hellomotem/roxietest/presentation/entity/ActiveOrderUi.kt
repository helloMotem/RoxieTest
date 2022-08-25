package com.hellomotem.roxietest.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActiveOrderUi(
    val id: Int,
    val startAddress: AddressUi,
    val endAddress: AddressUi,
    val price: PriceUi,
    val orderTime: String,
    val vehicle: VehicleUi
): Parcelable

fun ActiveOrderUi.getDate(): String = orderTime.split("T")[0]