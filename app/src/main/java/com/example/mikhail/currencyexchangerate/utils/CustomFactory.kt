package com.example.mikhail.currencyexchangerate.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.ui.quotes.QuotesAdapter
import com.example.mikhail.currencyexchangerate.ui.quotes.QuotesViewModel

class CustomFactory(
    private val storage: Storage,
    private val onItemClickListener: QuotesAdapter.OnItemClickListener?
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(storage, onItemClickListener) as T
    }
}
