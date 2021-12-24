package com.baharudin.pokemon.data.remote.repository

import com.baharudin.pokemon.data.remote.pokemondata.Pokemon
import com.baharudin.pokemon.data.remote.pokemonlist.PokemonListResponse
import com.baharudin.pokemon.util.Resource

interface PokemonRepo {

    suspend fun getAllPokemon(limit : Int, offset : Int) : Resource<PokemonListResponse>
    suspend fun getPokemonInfo(name : String) : Resource<Pokemon>
}