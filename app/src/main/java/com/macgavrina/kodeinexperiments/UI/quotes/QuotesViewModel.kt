package com.macgavrina.kodeinexperiments.UI.quotes

import androidx.lifecycle.ViewModel
import com.macgavrina.kodeinexperiments.data.model.Quote
import com.macgavrina.kodeinexperiments.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuote()
}