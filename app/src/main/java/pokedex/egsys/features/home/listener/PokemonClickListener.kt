package pokedex.egsys.features.home.listener

import pokedex.egsys.model.PokemonDataResponse

interface PokemonClickListener {
    fun onPokemonClick(pokemon : PokemonDataResponse)
}