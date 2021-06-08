package pokedex.egsys.model

import pokedex.egsys.model.responses.PokemonDataResponse

object PokemonDetails {
    var name: String = ""
    var image: String = ""
    var type: String = ""
    var weight: Int = 0
    var height: Int = 0


    fun setDetailsPokemon(body : PokemonDataResponse){
        name = body.name
        image = body.sprites.other.photo.front_default
        type = body.types.first().type.name
        weight = body.weight
        height = body.height
    }

    fun clean(){
        name = ""
        image = ""
        type = ""
        weight = 0
        height = 0
    }
}