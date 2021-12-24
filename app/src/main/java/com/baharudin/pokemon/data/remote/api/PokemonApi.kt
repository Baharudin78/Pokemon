package com.baharudin.pokemon.data.remote.api

import com.baharudin.pokemon.data.remote.pokemondata.Pokemon
import com.baharudin.pokemon.data.remote.pokemonlist.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getAllPokemon(
        @Query("limit") limit : Int,
        @Query("offset") offset : Int
    ) : PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name : String
    ): Pokemon
}