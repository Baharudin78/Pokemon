package com.baharudin.pokemon.data.remote.repository

import com.baharudin.pokemon.data.remote.api.PokemonApi
import com.baharudin.pokemon.data.remote.pokemondata.Pokemon
import com.baharudin.pokemon.data.remote.pokemonlist.PokemonListResponse
import com.baharudin.pokemon.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonRepo{
    override suspend fun getAllPokemon(limit: Int, offset: Int): Resource<PokemonListResponse> {
        val response = try {
            pokemonApi.getAllPokemon(limit, offset)
        }catch (e : Exception) {
            return Resource.Error("There is a problem.")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val response = try {
            pokemonApi.getPokemonInfo(name)
        }catch (e : Exception) {
            return Resource.Error("Error there.")
        }
        return Resource.Success(response)
    }
}