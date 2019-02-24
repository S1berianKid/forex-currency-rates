package com.example.mikhail.currencyexchangerate.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.ui.quotes.QuotesAdapter
import com.example.mikhail.currencyexchangerate.ui.quotes.QuotesViewModel

class CustomFactory(
    private val mStorage: Storage,
    private val mOnItemClickListener: QuotesAdapter.OnItemClickListener?
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(mStorage, mOnItemClickListener) as T
    }
}
