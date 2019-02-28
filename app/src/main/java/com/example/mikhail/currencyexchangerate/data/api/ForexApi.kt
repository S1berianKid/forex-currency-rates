package com.example.mikhail.currencyexchangerate.data.api

import com.example.mikhail.currencyexchangerate.data.model.Quote
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.atomic.AtomicReference

interface ForexApi {

    @GET("1.0.3/symbols")
    fun getQuotesNames(): Single<List<String>>

    @GET("1.0.3/quotes")
    fun getQuotesValuesAtomic(@Query("pairs") quotes: AtomicReference<String>): Single<List<Quote>>

}
