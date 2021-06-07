package pokedex.egsys.features.home

import pokedex.egsys.model.responses.PokemonDataResponse

interface PokemonClickListener {
    fun onPokemonClick(pokemon : PokemonDataResponse)
}