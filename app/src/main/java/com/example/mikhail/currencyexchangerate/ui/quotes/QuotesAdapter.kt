package com.example.mikhail.currencyexchangerate.ui.quotes

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.databinding.QuoteBinding

class QuotesAdapter(private val onItemClickListener: OnItemClickListener?) : ListAdapter<Quote, QuotesHolder>(diffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = QuoteBinding.inflate(inflater, parent, false)
        return QuotesHolder(binding)
    }

    override fun onBindViewHolder(holder: QuotesHolder, position: Int) {
        val pair = getItem(position)
        if (pair != null) {
            holder.bind(pair, onItemClickListener)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(symbol: String)
    }

    companion object {

        private val diffUtilItemCallback = object : DiffUtil.ItemCallback<Quote>() {
            override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                return oldItem.symbol.equals(newItem.symbol)
            }

            override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                return oldItem == newItem
            }
        }

    }


}
