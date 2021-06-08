package pokedex.egsys.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pokedex.egsys.features.home.viewModel.HomeViewModel
import pokedex.egsys.service.ClientService
import pokedex.egsys.service.PokemonRepository
import pokedex.egsys.service.PokemonService

object ApiModuleKoin {

    private val serviceModule = module {

        single<PokemonService> {
            ClientService().configureServiceEstabelecimento()
        }

    }
    private val viewModelModule = module {
        viewModel {
            HomeViewModel(
                get()
            )
        }
    }

    private val repositoryModule = module {
        single { PokemonRepository(get()) }
    }


    val modules = listOf(serviceModule, viewModelModule, repositoryModule)
}