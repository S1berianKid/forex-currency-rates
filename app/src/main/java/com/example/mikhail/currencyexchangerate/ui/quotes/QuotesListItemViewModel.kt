package com.example.mikhail.currencyexchangerate.ui.quotes

import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.utils.Utils

data class QuotesListItemViewModel(val item: Quote) {

    val symbol: String? = item.symbol

    val price: String?
        get() = Utils.formatDouble(item.price)

    val ask: String?
        get() =
            Utils.formatDouble(item.ask)

    val bid: String?
        get() =
            Utils.formatDouble(item.bid)

    val timestamp: String?
        get() = Utils.formatDate(item.timestamp)

}
