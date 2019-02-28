package com.example.mikhail.currencyexchangerate.ui.quotes

import android.support.v7.widget.RecyclerView
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.databinding.QuoteBinding

class QuotesHolder(private val quoteBinding: QuoteBinding) : RecyclerView.ViewHolder(quoteBinding.root) {

    fun bind(item: Quote, onItemClickListener: QuotesAdapter.OnItemClickListener?) {
        quoteBinding.quote = QuotesListItemViewModel(item)
        quoteBinding.onItemClickListener = onItemClickListener
        quoteBinding.executePendingBindings()
    }
}
