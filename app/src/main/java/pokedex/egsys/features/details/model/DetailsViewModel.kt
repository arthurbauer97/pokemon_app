package pokedex.egsys.features.details.model

import androidx.lifecycle.ViewModel
import pokedex.egsys.model.repository.PokemonRepository

class DetailsViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

}
