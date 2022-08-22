package com.hellomotem.roxietest.presentation.activeorders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hellomotem.roxietest.R
import com.hellomotem.roxietest.databinding.FragmentActiveOrdersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActiveOrdersFragment : Fragment(R.layout.fragment_active_orders) {

    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActiveOrdersViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                ActiveOrdersUiState.Default -> TODO()
                ActiveOrdersUiState.Error -> TODO()
                ActiveOrdersUiState.Loading -> TODO()
                is ActiveOrdersUiState.Success -> TODO()
            }
        }
    }

    fun loading() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = ActiveOrdersFragment()
    }
}
