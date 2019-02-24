package com.example.mikhail.currencyexchangerate.utils

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mikhail.currencyexchangerate.data.model.Quote
import com.example.mikhail.currencyexchangerate.ui.quotes.QuotesAdapter

object CustomBindingAdapter {

    @BindingAdapter("bind:data", "bind:clickHandler")
    @JvmStatic
    fun configureRecyclerView(
        recyclerView: RecyclerView?,
        quotes: List<Quote>?,
        clickListener: QuotesAdapter.OnItemClickListener?
    ) {
        val adapter = QuotesAdapter(clickListener)
        adapter.submitList(quotes)
        recyclerView?.layoutManager = LinearLayoutManager(recyclerView?.context)
        recyclerView?.adapter = adapter
    }

    @BindingAdapter("bind:scrollHandler")
    @JvmStatic
    fun configureRecyclerViewScroll(
        recyclerView: RecyclerView?,
        scrollListener: RecyclerView.OnScrollListener
    ) {
        recyclerView?.setOnScrollListener(scrollListener)
    }


    @BindingAdapter("bind:refreshState", "bind:onRefresh")
    @JvmStatic
    fun configureSwipeRefreshLayout(
        layout: SwipeRefreshLayout?,
        isLoading: Boolean?,
        listener: SwipeRefreshLayout.OnRefreshListener?
    ) {
        layout?.setOnRefreshListener(listener)
        layout?.post {
            if (isLoading != null) {
                layout.isRefreshing = isLoading
            }
        }
    }

}
