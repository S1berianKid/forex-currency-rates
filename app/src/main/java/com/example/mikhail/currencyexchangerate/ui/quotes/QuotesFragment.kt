package com.example.mikhail.currencyexchangerate.ui.quotes

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.mikhail.currencyexchangerate.data.Storage
import com.example.mikhail.currencyexchangerate.databinding.QuotesBinding
import com.example.mikhail.currencyexchangerate.ui.pair.PairActivity
import com.example.mikhail.currencyexchangerate.ui.pair.PairFragment
import com.example.mikhail.currencyexchangerate.utils.CustomFactory

class QuotesFragment : Fragment() {

    private var quotesViewModel: QuotesViewModel? = null

    companion object {

        fun newInstance(): QuotesFragment {
            return QuotesFragment()
        }
    }

    private val onItemClickListener = object : QuotesAdapter.OnItemClickListener {
        override fun onItemClick(symbol: String) {
            val intent = Intent(activity, PairActivity::class.java)
            val args = Bundle()
            args.putString(PairFragment.keySymbol, symbol)
            intent.putExtra(PairActivity.keyExtra, args)
            startActivity(intent)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Storage.StorageOwner) {
            val storage = (context as Storage.StorageOwner).obtainStorage()
            val factory = CustomFactory(storage, onItemClickListener)
            quotesViewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = QuotesBinding.inflate(inflater, container, false)
        binding.vm = quotesViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}
