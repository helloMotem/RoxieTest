package com.hellomotem.roxietest.presentation.activeorders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hellomotem.roxietest.databinding.RvActiveOrderItemBinding
import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi
import com.hellomotem.roxietest.presentation.entity.getDate
import com.hellomotem.roxietest.presentation.entity.toCurrencyFormat
import com.hellomotem.roxietest.presentation.entity.toStringFormat

class ActiveOrdersAdapter(
    val onClickAction: (ActiveOrderUi) -> Unit
) : RecyclerView.Adapter<ActiveOrdersAdapter.ActiveOrdersViewHolder>() {

    private val items = mutableListOf<ActiveOrderUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveOrdersViewHolder {
        val binding =
            RvActiveOrderItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ActiveOrdersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActiveOrdersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItems(orders: List<ActiveOrderUi>) {
        items.clear()
        items.addAll(orders)
        //TODO() should get removed (or not idk)
        notifyDataSetChanged()
    }

    inner class ActiveOrdersViewHolder(
        private val binding: RvActiveOrderItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ActiveOrderUi) = with(binding) {
            dateTv.text = item.getDate()
            priceTv.text = item.price.toCurrencyFormat()
            fromCityTv.text = item.startAddress.toStringFormat()
            toCityTv.text = item.endAddress.toStringFormat()

            root.setOnClickListener { onClickAction(item) }
        }
    }
}
