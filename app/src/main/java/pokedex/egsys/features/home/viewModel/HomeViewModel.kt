package pokedex.egsys.features.home.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pokedex.egsys.model.PokemonDataResponse
import pokedex.egsys.model.PokemonNameResponse
import pokedex.egsys.service.PokemonRepository

class HomeViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val TAG = HomeViewModel::class.java.simpleName

    val resultDataPokemons = MutableLiveData<List<PokemonDataResponse>>()
    val resultAllPokemons = MutableLiveData<PokemonNameResponse>()

    val listPokemons = mutableListOf<PokemonDataResponse>()

    fun getPokemonsData(pokemonId: Int) {
        viewModelScope.launch {
            runCatching {
                val pokemon = pokemonRepository.getPokemonsData(pokemonId).await()
                listPokemons.add(pokemon)
                resultDataPokemons.postValue(listPokemons)
            }.onFailure {
                it.printStackTrace()
                it.message?.let { it1 -> Log.d(TAG, it1) }
            }
        }
    }

    fun getAllPokemons(offset : Int = 0, limit : Int = 100) {
        viewModelScope.launch {
            runCatching {
                val pokemons = pokemonRepository.getAllPokemons(offset,limit).await()
                resultAllPokemons.postValue(pokemons)
            }.onFailure {
                it.printStackTrace()
                it.message?.let { it1 -> Log.d(TAG, it1) }
            }
        }
    }

}
