package com.example.mikhail.currencyexchangerate.ui.quotes

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.utils.ApiUtils
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import java.util.concurrent.atomic.AtomicReference

class QuotesModel(private var mStorage: Storage) {

    fun loadQuotesNames(): Single<List<String>> {
        return ApiUtils.apiService.getQuotesNames()
    }

    fun loadQuotesValues(currencies: AtomicReference<String>): Flowable<List<Quote>> {
        return ApiUtils.apiService.getQuotesValuesAtomic(currencies);
    }

    fun addQuotesNames(quotesNames: List<String>) {
        val quotes: ArrayList<Quote> = ArrayList()
        for (quote in quotesNames) {
            quotes.add(Quote(quote))
        }
        mStorage.insertQuotesNames(quotes)
    }

    fun addQuotesValues(quotes: List<Quote>) {
        mStorage.insertQuotesValues(quotes)
    }

}