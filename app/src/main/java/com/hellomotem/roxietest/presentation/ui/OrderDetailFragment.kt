package com.hellomotem.roxietest.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hellomotem.roxietest.R
import com.hellomotem.roxietest.databinding.FragmentOrderDetailBinding
import com.hellomotem.roxietest.presentation.entity.formatByNewLine
import com.hellomotem.roxietest.presentation.entity.toCurrencyFormat
import com.hellomotem.roxietest.presentation.entity.toStringFormat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OrderDetailFragment : Fragment() {

    private var _binding: FragmentOrderDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    if (it is OrdersState.Detail)
                        setDetails(it)
                }
            }
        }
    }

    private fun setDetails(detail: OrdersState.Detail) = with(binding) {
        carModelTv.text = detail.order.vehicle.modelName
        driverNameTv.text = detail.order.vehicle.driverName
        carRegNumberTv.text = detail.order.vehicle.regNumber

        fromCityTv.text = detail.order.startAddress.toStringFormat()
        toCityTv.text = detail.order.endAddress.toStringFormat()
        priceTv.text = detail.order.price.toCurrencyFormat()
        dateTv.text = detail.order.orderTime.formatByNewLine()

        val imageResource = detail.carImage
            ?: ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_car_placeholder,
                null
            )!!.toBitmap()
        carIv.setImageBitmap(imageResource)
    }

    override fun onDestroyView() {
        _binding = null
        viewModel.obtainEvent(ActiveOrdersEvent.Default)
        super.onDestroyView()
    }
}
