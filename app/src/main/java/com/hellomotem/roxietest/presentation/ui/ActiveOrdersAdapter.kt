package com.hellomotem.roxietest.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hellomotem.roxietest.databinding.RvActiveOrderItemBinding
import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi
import com.hellomotem.roxietest.presentation.entity.formatToYear
import com.hellomotem.roxietest.presentation.entity.toCurrencyFormat
import com.hellomotem.roxietest.presentation.entity.toStringFormat

class ActiveOrdersAdapter(
    val onClickAction: (ActiveOrderUi) -> Unit
) : RecyclerView.Adapter<ActiveOrdersAdapter.ActiveOrdersViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ActiveOrderUi>() {
        override fun areItemsTheSame(oldItem: ActiveOrderUi, newItem: ActiveOrderUi) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ActiveOrderUi, newItem: ActiveOrderUi) =
            oldItem == newItem
    }
    private val items = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveOrdersViewHolder {
        val binding =
            RvActiveOrderItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ActiveOrdersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActiveOrdersViewHolder, position: Int) =
        holder.bind(items.currentList[position])

    override fun getItemCount(): Int = items.currentList.size

    fun addItems(orders: List<ActiveOrderUi>) = items.submitList(orders)


    inner class ActiveOrdersViewHolder(
        private val binding: RvActiveOrderItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ActiveOrderUi) = with(binding) {
            dateTv.text = item.orderTime.formatToYear()
            priceTv.text = item.price.toCurrencyFormat()
            fromCityTv.text = item.startAddress.toStringFormat()
            toCityTv.text = item.endAddress.toStringFormat()

            root.setOnClickListener { onClickAction(item) }
        }
    }
}
