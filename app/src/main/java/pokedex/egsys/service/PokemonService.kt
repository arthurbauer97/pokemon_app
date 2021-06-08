package pokedex.egsys.service

import pokedex.egsys.model.responses.PokemonDataResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{id}/")
    suspend fun getPokemonsData(
        @Path("id") id: Int
    ): PokemonDataResponse
}