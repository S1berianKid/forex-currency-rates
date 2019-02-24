package com.example.mikhail.currencyexchangerate.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList

import com.example.mikhail.currencyexchangerate.data.database.ForexDao
import com.example.mikhail.currencyexchangerate.data.model.Quote

class Storage(private val mForexDao: ForexDao) {

    val quotes: LiveData<List<Quote>>
        get() = mForexDao.getQuotes()

    val quotesPaged: LiveData<PagedList<Quote>>
        get() = LivePagedListBuilder(mForexDao.getQuotesPaged(), PAGE_SIZE).build()

    fun insertQuotesNames(quotes: List<Quote>) {
        mForexDao.insertQuotesNames(quotes)
    }

    fun insertQuotesValues(quotes: List<Quote>) {
        mForexDao.insertQuotesValues(quotes)
    }

    interface StorageOwner {
        fun obtainStorage(): Storage
    }

    companion object {
        var PAGE_SIZE = 15
    }

}
