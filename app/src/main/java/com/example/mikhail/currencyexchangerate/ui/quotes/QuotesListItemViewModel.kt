package com.example.mikhail.currencyexchangerate.ui.quotes

import com.example.mikhail.currencyexchangerate.data.model.Quote

class QuotesListItemViewModel(item: Quote) {

    val symbol: String?
    val price: Double?
    val ask: Double?
    val bid: Double?
    val timestamp: Int?

    init {
        symbol = item.symbol
        price = item.price
        ask = item.ask
        bid = item.bid
        timestamp = item.timestamp
    }

    companion object {
        private val FIRST_OWNER_INDEX = 0
    }
}
