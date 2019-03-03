package com.example.mikhail.currencyexchangerate.ui.pair

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.databinding.PairBinding

class PairFragment : Fragment() {

    private var pairViewModel: PairViewModel? = null

    companion object {

        const val keySymbol: String = "KEY_SYMBOL"

        fun newInstance(bundle: Bundle?): PairFragment {
            val pairFragment = PairFragment()
            pairFragment.arguments = bundle
            return pairFragment
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Storage.StorageOwner) {
            val storage = (context as Storage.StorageOwner).obtainStorage()
            val symbol = arguments?.getString(keySymbol);
            val factory = CustomFactory(storage, symbol)
            pairViewModel = ViewModelProviders.of(this, factory).get(PairViewModel::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = PairBinding.inflate(inflater, container, false)
        binding.viewModel = pairViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    class CustomFactory(private val storage: Storage, private val symbol: String?) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PairViewModel(storage, symbol) as T
        }
    }

}
