package com.hellomotem.roxietest.presentation.mapper

interface Mapper<in SRC, out DST> {
    fun map(data: SRC): DST
}