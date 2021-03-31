package pokedex.egsys.model.service

import pokedex.egsys.model.responses.PokemonDataResponse
import pokedex.egsys.model.responses.PokemonNameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon-form")
    suspend fun getPokemonsNames(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int

    ): PokemonNameResponse

    @GET("pokemon/{id}/")
    suspend fun getPokemonsData(
        @Path("id") nome: String

    ): PokemonDataResponse
}