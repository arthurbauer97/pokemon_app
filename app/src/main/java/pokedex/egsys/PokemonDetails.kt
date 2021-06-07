package pokedex.egsys

import pokedex.egsys.model.responses.PokemonDataResponse

object PokemonDetails {
    var name: String = ""
    var image: String = ""
    var type: String = ""
    var weight: Int = 0
    var height: Int = 0


    fun setDetailsPokemon(body : PokemonDataResponse){
        this.name = body.name
        this.image = body.sprites.other.photo.front_default
        this.type = body.types.first().type.name
        this.weight = body.weight
        this.height = body.height
    }

    fun clean(){
        this.name = ""
        this.image = ""
        this.type = ""
        this.weight = 0
        this.height = 0
    }
}