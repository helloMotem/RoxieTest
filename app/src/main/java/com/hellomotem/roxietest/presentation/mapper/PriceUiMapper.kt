package com.hellomotem.roxietest.presentation.mapper

import com.hellomotem.roxietest.data.mapper.Mapper
import com.hellomotem.roxietest.domain.entity.Price
import com.hellomotem.roxietest.presentation.entity.PriceUi

class PriceUiMapper : Mapper<Price, PriceUi> {
    override fun map(data: Price): PriceUi = PriceUi(
        amount = data.amount,
        currency = data.currency
    )
}