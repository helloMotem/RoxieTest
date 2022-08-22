package com.hellomotem.roxietest.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hellomotem.roxietest.R
import com.hellomotem.roxietest.presentation.viewmodel.ActiveOrdersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActiveOrdersFragment : Fragment() {

    private val viewModel: ActiveOrdersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_active_orders, container, false)
    }

    companion object {
        fun newInstance() = ActiveOrdersFragment()
    }
}
