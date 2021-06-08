package pokedex.egsys.features.home.listener

import pokedex.egsys.model.responses.PokemonDataResponse

interface PokemonClickListener {
    fun onPokemonClick(pokemon : PokemonDataResponse)
}