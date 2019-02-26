package com.example.mikhail.currencyexchangerate.data.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.mikhail.currencyexchangerate.data.model.Quote

@Dao
interface ForexDao {

    @Query("select * from quote order by symbol")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertQuotesNames(quotes: List<Quote>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuotesValues(quotes: List<Quote>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuoteValues(quotes: Quote)

}
