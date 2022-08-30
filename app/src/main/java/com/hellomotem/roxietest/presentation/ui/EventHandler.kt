package com.hellomotem.roxietest.presentation.ui

interface EventHandler<E> {

    fun obtainEvent(event: E)
}