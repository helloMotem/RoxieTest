package com.hellomotem.roxietest.presentation.entity

import java.text.NumberFormat
import java.util.*

data class PriceUi(
    val amount: Double,
    val currency: String
)

fun PriceUi.toCurrencyFormat(): String {
    val format = NumberFormat.getCurrencyInstance()
    format.currency = Currency.getInstance(currency)
    format.minimumFractionDigits = 2
    return format.format(amount)
}

