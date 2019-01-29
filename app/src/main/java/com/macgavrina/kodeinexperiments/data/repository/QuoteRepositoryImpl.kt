package com.macgavrina.kodeinexperiments.data.repository

import androidx.lifecycle.LiveData
import com.macgavrina.kodeinexperiments.data.DB.QuoteDao
import com.macgavrina.kodeinexperiments.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao:QuoteDao): QuoteRepository {

    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuote() = quoteDao.getQuote()

}