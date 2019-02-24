package com.example.mikhail.currencyexchangerate.common

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout

import com.example.mikhail.currencyexchangerate.R

abstract class RefreshActivity : SingleFragmentActivity(), SwipeRefreshLayout.OnRefreshListener, RefreshOwner {

    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null

    override val layout: Int
        get() = R.layout.activity_swipe_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSwipeRefreshLayout = findViewById(R.id.refresher)
        mSwipeRefreshLayout!!.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (fragment is Refreshable) {
            (fragment as Refreshable).onRefreshData()
        } else {
            setRefreshState(false)
        }
    }

    override fun setRefreshState(refreshing: Boolean) {
        mSwipeRefreshLayout!!.post { mSwipeRefreshLayout!!.isRefreshing = refreshing }
    }

}
