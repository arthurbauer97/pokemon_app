package pokedex.egsys.features.home.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pokedex.egsys.service.PokemonRepository
import pokedex.egsys.model.responses.PokemonDataResponse

class HomeViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val TAG = HomeViewModel::class.java.simpleName

    val resultDataPokemons = MutableLiveData<List<PokemonDataResponse>>()
    val listPokemons = mutableListOf<PokemonDataResponse>()

    fun getPokemonsData(pokemonId: Int) {
        viewModelScope.launch {
            runCatching {
                val pokemons = pokemonRepository.getPokemonsData(pokemonId).await()
                listPokemons.add(pokemons)
                resultDataPokemons.postValue(listPokemons)
            }.onFailure {
                it.printStackTrace()
                it.message?.let { it1 -> Log.d(TAG, it1) }
            }
        }
    }
}
