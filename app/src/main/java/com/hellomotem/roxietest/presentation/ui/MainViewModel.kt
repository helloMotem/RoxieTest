package com.hellomotem.roxietest.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.*
import com.hellomotem.roxietest.data.DeleteWorker
import com.hellomotem.roxietest.domain.entity.CarImage
import com.hellomotem.roxietest.domain.usecase.GetActiveOrdersUseCase
import com.hellomotem.roxietest.domain.usecase.GetCarImageUseCase
import com.hellomotem.roxietest.domain.usecase.SaveCarImageUseCase
import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi
import com.hellomotem.roxietest.presentation.mapper.ActiveOrderUiMapper
import com.hellomotem.roxietest.presentation.mapper.CarImageUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Duration
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getActiveOrdersUseCase: GetActiveOrdersUseCase,
    private val getCarImageUseCase: GetCarImageUseCase,
    private val saveCarImageUseCase: SaveCarImageUseCase,
    private val activeOrderUiMapper: ActiveOrderUiMapper,
    private val carImageUiMapper: CarImageUiMapper,
    private val workManager: WorkManager
) : ViewModel(), EventHandler<ActiveOrdersEvent> {

    private val _state = MutableStateFlow<OrdersState>(OrdersState.Loading)
    val state: StateFlow<OrdersState> = _state

    init {
        getActiveOrders()
    }

    override fun obtainEvent(event: ActiveOrdersEvent) {
        when (event) {
            ActiveOrdersEvent.Default -> getActiveOrders()
            is ActiveOrdersEvent.OnItemClicked -> {
                getCarImage(event.item)
            }
        }
    }

    private fun getActiveOrders() = viewModelScope.launch {
        _state.value = OrdersState.Loading
        _state.value = getActiveOrdersUseCase()?.let {
            OrdersState.Orders(activeOrderUiMapper.map(it))
        } ?: OrdersState.Loading
    }

    private fun getCarImage(item: ActiveOrderUi) = viewModelScope.launch {
        _state.value = OrdersState.Loading
        _state.value = getCarImageUseCase(item.vehicle.photo).let { carImage ->
            if (carImage is CarImage.ApiCarImage) {
                saveCarImageUseCase(item.vehicle.photo, carImage)
                deleteFromCache(item.vehicle.photo)
            }

            OrdersState.Detail(item, carImageUiMapper.map(carImage))
        }
    }

    private fun deleteFromCache(name: String) {
        val data = workDataOf("imageName" to name)
        val work = OneTimeWorkRequestBuilder<DeleteWorker>()
            .setInputData(data)
            .setInitialDelay(Duration.ofMinutes(CACHE_TIME))
            .build()
        workManager.enqueue(work)
    }

    companion object {
        private const val CACHE_TIME = 10L
    }
}

