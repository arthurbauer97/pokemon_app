package pokedex.egsys.service

import pokedex.egsys.model.PokemonNameResponse
import pokedex.egsys.model.responses.PokemonDataResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{id}/")
    suspend fun getPokemonsData(
        @Path("id") id: Int
    ): PokemonDataResponse

    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("offset") offset : Int,
        @Query("limit") limit : Int
    ) : PokemonNameResponse
}