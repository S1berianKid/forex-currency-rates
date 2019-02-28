package com.example.mikhail.currencyexchangerate.utils

import com.example.mikhail.currencyexchangerate.BuildConfig
import com.example.mikhail.currencyexchangerate.data.api.ApiKeyInterceptor
import com.example.mikhail.currencyexchangerate.data.api.ForexApi
import com.google.gson.Gson

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

    private var forexApi: ForexApi? = null

    fun getApiService(): ForexApi {

        if (forexApi == null) {

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(OkHttpClient().newBuilder().addInterceptor(ApiKeyInterceptor()).build())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            forexApi = retrofit.create<ForexApi>(ForexApi::class.java)

        }

        return this.forexApi!!

    }

}
