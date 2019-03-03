package com.example.mikhail.currencyexchangerate.ui.pair

import android.support.v4.app.Fragment

import com.example.mikhail.currencyexchangerate.AppDelegate
import com.example.mikhail.currencyexchangerate.common.SingleFragmentActivity
import com.example.mikhail.currencyexchangerate.data.Storage

class PairActivity : SingleFragmentActivity(), Storage.StorageOwner {

    companion object {
        const val keyExtra: String = "KEY_EXTRA"
    }

    override val fragment: Fragment
        get() = PairFragment.newInstance(intent.extras?.getBundle(keyExtra))

    override fun obtainStorage(): Storage {
        return (applicationContext as AppDelegate).storage
    }
}
