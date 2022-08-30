package com.hellomotem.roxietest.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellomotem.roxietest.databinding.FragmentActiveOrdersBinding
import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi
import com.hellomotem.roxietest.presentation.navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ActiveOrdersFragment : Fragment() {

    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activeOrdersAdapter = ActiveOrdersAdapter { navigateToDetails(it) }

        binding.activeOrdersRv.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = activeOrdersAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    if (it is OrdersState.Orders) {
                        successState(it.orders, adapter = activeOrdersAdapter)
                    }
                }
            }
        }
    }

    private fun successState(
        list: List<ActiveOrderUi>,
        adapter: ActiveOrdersAdapter
    ) = adapter.addItems(list)


    private fun navigateToDetails(item: ActiveOrderUi) {
        viewModel.obtainEvent(ActiveOrdersEvent.OnItemClicked(item))
        navigator().showOrderDetailsScreen()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
