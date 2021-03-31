package pokedex.egsys.model.responses

import com.google.gson.annotations.SerializedName

data class PokemonDataResponse(
    val height: Int,
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<Types>,
    val weight: Int
)

data class Types(
    val slot: Int,
    val type: TypeX
)

data class TypeX(
    val name: String,
    val url: String
)


data class Sprites(
    val other: Other
)

data class Other(
    val dream_world: DreamWorld,
    @SerializedName("official-artwork")
    val photo: OfficialArtwork
)

data class OfficialArtwork(
    val front_default: String
)

data class DreamWorld(
    val front_default: String,
    val front_female: Any
)