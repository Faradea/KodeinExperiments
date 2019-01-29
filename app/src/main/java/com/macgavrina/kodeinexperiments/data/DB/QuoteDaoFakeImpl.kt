package com.macgavrina.kodeinexperiments.data.DB

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.macgavrina.kodeinexperiments.data.model.Quote

class QuoteDaoFakeImpl: QuoteDao {

    private val quoteList = mutableListOf<Quote>()

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuote() = quotes as LiveData<List<Quote>>
}