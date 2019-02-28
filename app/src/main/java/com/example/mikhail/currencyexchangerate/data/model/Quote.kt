package com.example.mikhail.currencyexchangerate.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
class Quote() {

    constructor(mSymbol: String) : this() {
        symbol = mSymbol
    }

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "symbol")
    var symbol: String? = null

    @ColumnInfo(name = "price")
    var price: Double? = null

    @ColumnInfo(name = "ask")
    var ask: Double? = null

    @ColumnInfo(name = "bid")
    var bid: Double? = null

    @ColumnInfo(name = "timestamp")
    var timestamp: Int? = null

}