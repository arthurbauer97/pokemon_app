package pokedex.egsys.features.home.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import pokedex.egsys.model.repository.PokemonRepository
import pokedex.egsys.model.responses.PokemonDataResponse

class HomeViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val TAG = HomeViewModel::class.java.simpleName
    private val viewModelJob = SupervisorJob()
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun searchRepo(): Flow<PagingData<PokemonDataResponse>> {
        val newResult: Flow<PagingData<PokemonDataResponse>> = pokemonRepository.getPokemonsName()
            .cachedIn(viewModelScope)
        return newResult
    }

//    fun getDataPokemons(nomePokemon: String) {
//        uiScope.launch {
//            runCatching {
//                val pokemons = pokemonRepository.getDataPokemons(nomePokemon)
//                resultDataPokemons.value = pokemons
//
//            }.onFailure {
//                it.printStackTrace()
//                it.message?.let { it1 -> Log.d(TAG, it1) }
//            }
//        }
//    }
}
