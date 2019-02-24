package com.example.mikhail.currencyexchangerate

import android.app.Application
import android.arch.persistence.room.Room
import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.data.database.ForexDatabase

class AppDelegate : Application() {

    lateinit var storage: Storage
        private set

    override fun onCreate() {
        super.onCreate()

        val database = Room.databaseBuilder(this, ForexDatabase::class.java, "forex_database")
            .fallbackToDestructiveMigration()
            .build()

        storage = Storage(database.forexDao)
    }
}
