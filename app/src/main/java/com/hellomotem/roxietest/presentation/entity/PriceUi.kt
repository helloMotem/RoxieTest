package com.hellomotem.roxietest.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.NumberFormat
import java.util.*

@Parcelize
data class PriceUi(
    val amount: Long,
    val currency: String
): Parcelable

fun PriceUi.toCurrencyFormat(): String {
    val format = NumberFormat.getCurrencyInstance()
    //format.maximumFractionDigits = 2
    format.minimumFractionDigits = 2
    format.currency = Currency.getInstance(currency)
    return format.format(amount.toDouble())
//    val amountString = amount.toString()
//    if (amountString.length < 2) return "0.$amount"
//    amountString
}
