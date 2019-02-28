package com.example.mikhail.currencyexchangerate.ui.quotes

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.utils.ApiUtils
import io.reactivex.Single
import java.util.*
import java.util.concurrent.atomic.AtomicReference

class QuotesModel(private var storage: Storage) {

    fun loadQuotesNames(): Single<List<String>> {
        return ApiUtils.getApiService().getQuotesNames()
    }

    fun loadQuotesValues(currencies: AtomicReference<String>): Single<List<Quote>> {
        return ApiUtils.getApiService().getQuotesValuesAtomic(currencies);
    }

    fun addQuotesNames(quotesNames: List<String>) {
        val quotes: ArrayList<Quote> = ArrayList()
        for (quote in quotesNames) {
            quotes.add(Quote(quote))
        }
        storage.insertQuotesNames(quotes)
    }

    fun addQuotesValues(quotes: List<Quote>) {
        storage.insertQuotesValues(quotes)
    }

}