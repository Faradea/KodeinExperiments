package com.macgavrina.kodeinexperiments.data.repository

import androidx.lifecycle.LiveData
import com.macgavrina.kodeinexperiments.data.model.Quote

interface QuoteRepository {

    fun addQuote(quote: Quote)

    fun getQuote(): LiveData<List<Quote>>

}