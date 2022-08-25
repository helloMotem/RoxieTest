package com.hellomotem.roxietest.presentation.activeorders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellomotem.roxietest.R
import com.hellomotem.roxietest.databinding.FragmentActiveOrdersBinding
import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActiveOrdersFragment : Fragment(R.layout.fragment_active_orders) {

    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActiveOrdersViewModel by viewModels()
    //val args: ActiveOrderFr

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activeOrdersAdapter = ActiveOrdersAdapter { navigate(it) }

        binding.activeOrdersRv.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = activeOrdersAdapter
        }

        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                ActiveOrdersUiState.Default -> defaultState()
                ActiveOrdersUiState.Error -> errorState()
                ActiveOrdersUiState.Loading -> loadingState()
                is ActiveOrdersUiState.Success -> successState(it.orders, activeOrdersAdapter)
            }
        }
    }

    private fun loadingState() {

    }

    private fun errorState() {}

    private fun successState(orders: List<ActiveOrderUi>, adapter: ActiveOrdersAdapter) {
        adapter.addItems(orders)
    }

    private fun defaultState() {}

    private fun navigate(order: ActiveOrderUi) {
        val action = ActiveOrdersFragmentDirections.actionActiveOrdersToDetails(order)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = ActiveOrdersFragment()
    }
}
