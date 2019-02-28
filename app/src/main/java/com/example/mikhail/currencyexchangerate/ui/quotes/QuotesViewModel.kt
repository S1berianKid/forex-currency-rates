package com.example.mikhail.currencyexchangerate.ui.quotes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.data.model.Quote
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

class QuotesViewModel(mStorage: Storage, val onItemClickListener: QuotesAdapter.OnItemClickListener?) : ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var model: QuotesModel = QuotesModel(mStorage)
    var quotes: LiveData<List<Quote>> = mStorage.quotes

    val isLoading = MutableLiveData<Boolean>()
    val isErrorVisible = MutableLiveData<Boolean>()
    val visibleCurrencies: AtomicReference<String> = AtomicReference()

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        loadQuotesNames()
    }

    // При прокрутке списка сохраняем отображённые на экране котировки в атомарную переменную, со значениями которой потом работает Retrofit
    val onScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            var currencies = String()

            val layoutManager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager;

            val firstVisiblePosition: Int = layoutManager.findFirstVisibleItemPosition()
            val lastVisiblePosition: Int = layoutManager.findLastVisibleItemPosition()

            for (i in firstVisiblePosition..lastVisiblePosition) {

                currencies = currencies.plus(quotes.value?.get(i)?.symbol)

                if (i != lastVisiblePosition) {
                    currencies = currencies.plus(",")
                }
            }

            visibleCurrencies.set(currencies)

            super.onScrolled(recyclerView, dx, dy)
        }

    }

    init {
        loadQuotesNames()
        loadQuotesValues()
    }

    // Загружаем все названия котировок и сохраняем их в локальную базу
    private fun loadQuotesNames() {

        compositeDisposable.add(
            model.loadQuotesNames()
                .doOnSubscribe { isLoading.postValue(true) }
                .doOnError { isLoading.postValue(true) }
                .doFinally { isLoading.postValue(false) }
                .doOnSuccess { isErrorVisible.postValue(false) }
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { response ->
                        model.addQuotesNames(response)
                    },
                    { isErrorVisible.postValue(true) })
        )

    }

    // Загружаем все значения котировок. Первая загрузка без фильтра, все последующие - с фильтром
    private fun loadQuotesValues() {

        compositeDisposable.add(
            model.loadQuotesValues(visibleCurrencies)
                .delay(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .repeat()
                .subscribe(
                    { response -> model.addQuotesValues(response) },
                    { isErrorVisible.postValue(true) }))

    }


    public override fun onCleared() {
        compositeDisposable.dispose()
    }
}
