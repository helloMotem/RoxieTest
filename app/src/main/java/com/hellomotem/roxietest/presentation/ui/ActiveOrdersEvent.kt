package com.hellomotem.roxietest.presentation.ui

import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi

sealed interface ActiveOrdersEvent {
    data class OnItemClicked(val item: ActiveOrderUi): ActiveOrdersEvent
    object Default: ActiveOrdersEvent
}