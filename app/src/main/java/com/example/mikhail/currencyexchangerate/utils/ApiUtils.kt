package com.example.mikhail.currencyexchangerate.utils

import com.example.mikhail.currencyexchangerate.BuildConfig
import com.example.mikhail.currencyexchangerate.data.api.ApiKeyInterceptor
import com.example.mikhail.currencyexchangerate.data.api.ForexApi
import com.google.gson.Gson

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.Arrays

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object ApiUtils {

    private lateinit var sClient: OkHttpClient
    private lateinit var sRetrofit: Retrofit
    private lateinit var sGson: Gson
    private lateinit var sApi: ForexApi

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient().newBuilder()
            builder.addInterceptor(ApiKeyInterceptor())
            if (!BuildConfig.BUILD_TYPE.contains("release")) {
                builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
            sClient = builder.build()
            return sClient
        }

    private val retrofit: Retrofit
        get() {
            sGson = Gson()
            sRetrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(sGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return sRetrofit
        }

    val apiService: ForexApi
        get() {
            sApi = retrofit.create(ForexApi::class.java)
            return sApi
        }
}
