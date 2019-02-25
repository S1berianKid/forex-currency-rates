package com.example.mikhail.currencyexchangerate.ui.quotes

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.databinding.QuoteBinding

class QuotesAdapter(private val mOnItemClickListener: OnItemClickListener?) : ListAdapter<Quote, QuotesHolder>(DiffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = QuoteBinding.inflate(inflater, parent, false)
        return QuotesHolder(binding)
    }

    override fun onBindViewHolder(holder: QuotesHolder, position: Int) {
        val pair = getItem(position)
        if (pair != null) {
            holder.bind(pair, mOnItemClickListener)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(symbol: String)
    }

    companion object {

        private val DiffUtilItemCallback = object : DiffUtil.ItemCallback<Quote>() {
            override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                val same: Boolean = oldItem.symbol.equals(newItem.symbol)
                return same
            }

            override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                val same: Boolean = oldItem == newItem
                return same
            }
        }

    }


}
