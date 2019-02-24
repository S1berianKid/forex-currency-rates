package com.example.mikhail.currencyexchangerate.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.mikhail.currencyexchangerate.data.model.Quote

@Database(entities = [Quote::class], version = 1)
abstract class ForexDatabase : RoomDatabase() {

    abstract val forexDao: ForexDao

}
