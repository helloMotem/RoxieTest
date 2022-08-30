package com.hellomotem.roxietest.presentation

import androidx.fragment.app.Fragment

interface Navigator {

    fun showOrderDetailsScreen()

    fun back()
}

fun Fragment.navigator() = requireActivity() as Navigator