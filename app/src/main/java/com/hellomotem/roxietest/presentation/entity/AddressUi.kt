package com.hellomotem.roxietest.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddressUi(
    val city: String,
    val address: String
): Parcelable

fun AddressUi.toStringFormat() = "$address, $city"