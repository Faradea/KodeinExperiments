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
import org.kodein.di.generic.*

class QuotesApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        //Pattern: bind<TYPE>() with
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }

        //This binds a type to a provider function, which is a function that takes no arguments and returns an object of the bound type (eg. () → T).
        //The provided function will be called each time you need an instance of the bound type.
        bind<QuotesViewModelFactory>() with provider { QuotesViewModelFactory(instance()) }


        //Factory
        //This binds a type to a factory function, which is a function that takes an argument of a defined type and that returns an object of the bound type (eg. (A) → T).
        //The provided function will be called each time you need an instance of the bound type.

        constant(tag = "serverURL") with "https://my.server.url"
    }
}