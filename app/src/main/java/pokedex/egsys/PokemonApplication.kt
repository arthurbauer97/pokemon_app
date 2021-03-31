package pokedex.egsys

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import pokedex.egsys.di.ApiModuleKoin

class PokemonApplication : Application() {

    companion object {
        var appContext: Context? = null
            private set

        lateinit var estabelecimentoApplication: PokemonApplication private set
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        startKoin {
            androidLogger(Level.NONE)
            androidContext(applicationContext)
            modules(ApiModuleKoin.modules)
        }

        estabelecimentoApplication = this
    }


}