package com.example.mikhail.currencyexchangerate.ui.pair

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.widget.SwipeRefreshLayout

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.utils.Utils
import io.reactivex.disposables.CompositeDisposable

class PairViewModel(storage: Storage, symbol: String?) : ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var qoute: LiveData<Quote> = storage.getQuote(symbol)

    val isLoading = MutableLiveData<Boolean>()

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener { /*TODO*/ }

    init {
        /* TODO */
    }

    public override fun onCleared() {
        compositeDisposable.dispose()
    }

}
