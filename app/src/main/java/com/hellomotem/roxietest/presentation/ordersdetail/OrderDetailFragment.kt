package com.hellomotem.roxietest.presentation.ordersdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.hellomotem.roxietest.R
import com.hellomotem.roxietest.databinding.FragmentOrderDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderDetailFragment : Fragment(R.layout.fragment_order_detail) {

    private var _binding: FragmentOrderDetailBinding? = null
    private val binding get() =  _binding!!

    private val viewModel: OrderDetailViewModel by viewModels()
    private val args: OrderDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(args.orderArgs) {
        super.onViewCreated(view, savedInstanceState)
        binding.carModelTv.text = this.vehicle.modelName
    }

    companion object {
        fun newInstance() = OrderDetailFragment()
    }
}
