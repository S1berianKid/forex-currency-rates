package com.example.mikhail.currencyexchangerate.ui.quotes

import android.support.v4.app.Fragment

import com.example.mikhail.currencyexchangerate.AppDelegate
import com.example.mikhail.currencyexchangerate.common.SingleFragmentActivity
import com.example.mikhail.currencyexchangerate.data.Storage

class QuotesActivity : SingleFragmentActivity(), Storage.StorageOwner {

    override val fragment: Fragment
        get() = QuotesFragment.newInstance()

    override fun obtainStorage(): Storage {
        return (applicationContext as AppDelegate).storage
    }
}
