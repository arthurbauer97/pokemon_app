package pokedex.egsys.service

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class PokemonRepository(private val api: PokemonService) {

    suspend fun getPokemonsData(pokemonId: Int) = withContext(IO) {
        async { api.getPokemonsData(pokemonId) }
    }

    suspend fun getAllPokemons(offset: Int, limit : Int) = withContext(IO) {
        async { api.getAllPokemons(offset,limit) }
    }
}