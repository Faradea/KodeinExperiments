package com.macgavrina.kodeinexperiments

import android.app.Application
import com.macgavrina.kodeinexperiments.UI.quotes.QuotesViewModelFactory
import com.macgavrina.kodeinexperiments.data.DB.Database
import com.macgavrina.kodeinexperiments.data.DB.DatabaseFakeImpl
import com.macgavrina.kodeinexperiments.data.DB.QuoteDao
import com.macgavrina.kodeinexperiments.data.DB.QuoteDaoFakeImpl
import com.macgavrina.kodeinexperiments.data.repository.QuoteRepository
import com.macgavrina.kodeinexperiments.data.repository.QuoteRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        //Pattern: bind<TYPE>() with
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }
        bind<QuotesViewModelFactory>() with provider { QuotesViewModelFactory(instance()) }
    }
}