package com.macgavrina.kodeinexperiments.data.DB

import androidx.lifecycle.LiveData
import com.macgavrina.kodeinexperiments.data.model.Quote

interface QuoteDao {

    fun addQuote(quote: Quote)

    fun getQuote(): LiveData<List<Quote>>
}