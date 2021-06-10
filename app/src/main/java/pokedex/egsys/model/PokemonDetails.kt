package pokedex.egsys.model

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
}