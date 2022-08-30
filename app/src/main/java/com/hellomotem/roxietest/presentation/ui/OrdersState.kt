package com.hellomotem.roxietest.presentation.ui

import android.graphics.Bitmap
import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi


sealed interface OrdersState {
    data class Orders(
        val orders: List<ActiveOrderUi>
    ) : OrdersState

    data class Detail(
        val order: ActiveOrderUi,
        val carImage: Bitmap?
    ) : OrdersState

    object Loading: OrdersState
}
