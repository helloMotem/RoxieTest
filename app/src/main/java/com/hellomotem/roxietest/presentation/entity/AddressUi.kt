package com.hellomotem.roxietest.presentation.entity

data class AddressUi(
    val city: String,
    val address: String
)

fun AddressUi.toStringFormat() = "$address, $city"