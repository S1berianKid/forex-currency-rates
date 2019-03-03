package com.example.mikhail.currencyexchangerate.data

import android.arch.lifecycle.LiveData

import com.example.mikhail.currencyexchangerate.data.database.ForexDao
import com.example.mikhail.currencyexchangerate.data.model.Quote

class Storage(private val forexDao: ForexDao) {

    val quotes: LiveData<List<Quote>>
        get() = forexDao.getQuotes()

    fun getQuote(symbol: String?): LiveData<Quote> {
        return forexDao.getQuote(symbol.toString())
    }

    fun insertQuotesNames(quotes: List<Quote>) {
        forexDao.insertQuotesNames(quotes)
    }

    fun insertQuotesValues(quotes: List<Quote>) {
        forexDao.insertQuotesValues(quotes)
    }

    interface StorageOwner {
        fun obtainStorage(): Storage
    }

}
