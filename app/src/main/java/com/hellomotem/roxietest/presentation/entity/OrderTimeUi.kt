package com.hellomotem.roxietest.presentation.entity

data class OrderTimeUi(
    val time: String
)

fun OrderTimeUi.formatByNewLine(): String{
    val formatted = time.split("T", "+")
    return "${formatted[0]}\n${formatted[1]}"
}

fun OrderTimeUi.formatToYear(): String {
    val formatted = time.split("T", "+")
    return formatted[0]
}
