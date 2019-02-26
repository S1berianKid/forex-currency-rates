package com.example.mikhail.currencyexchangerate.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

import com.example.mikhail.currencyexchangerate.R

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected open val layout: Int
        get() = R.layout.activity_container

    protected abstract val fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)

        if (savedInstanceState == null) {
            changeFragment(fragment)
        }

    }

    private fun changeFragment(fragment: Fragment) {
        val addToBackStack = supportFragmentManager.findFragmentById(R.id.fragmentContainer) != null

        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }

        transaction.commit()
    }

}
