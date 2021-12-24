package com.baharudin.pokemon.data.remote.pokemondata

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)