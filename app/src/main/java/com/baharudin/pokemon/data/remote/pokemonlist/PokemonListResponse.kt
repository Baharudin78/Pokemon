package com.baharudin.pokemon.data.remote.pokemonlist

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)