package com.hellomotem.roxietest.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hellomotem.roxietest.R

class OrderDetailFragment : Fragment() {

    private lateinit var viewModel: OrderDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[OrderDetailViewModel::class.java]
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = OrderDetailFragment()
    }
}
