package com.hellomotem.roxietest.data.mapper

interface Mapper<in SRC, out DST> {
    fun map(data: SRC): DST
}

