package com.hellomotem.roxietest.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hellomotem.roxietest.R

class ActiveOrdersFragment : Fragment() {

    private lateinit var viewModel: ActiveOrdersViewModel

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
