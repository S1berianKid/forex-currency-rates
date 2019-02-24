package com.example.mikhail.currencyexchangerate.ui.quotes

import android.support.v7.widget.RecyclerView
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.databinding.QuoteBinding

class QuotesHolder(private val mQuoteBinding: QuoteBinding) : RecyclerView.ViewHolder(mQuoteBinding.root) {

    fun bind(item: Quote, onItemClickListener: QuotesAdapter.OnItemClickListener?) {
        mQuoteBinding.quote = QuotesListItemViewModel(item)
        mQuoteBinding.onItemClickListener = onItemClickListener
        mQuoteBinding.executePendingBindings()
    }
}
