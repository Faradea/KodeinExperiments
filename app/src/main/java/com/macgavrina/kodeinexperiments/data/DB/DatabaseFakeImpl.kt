package com.macgavrina.kodeinexperiments.data.DB

class DatabaseFakeImpl:Database {

    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}