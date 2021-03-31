package pokedex.egsys.model.responses

data class PokemonNameResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ResultName>
)

data class ResultName(
    val name: String,
    val url: String
)