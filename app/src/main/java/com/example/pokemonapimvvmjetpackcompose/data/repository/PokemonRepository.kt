package com.example.pokemonapimvvmjetpackcompose.data.repository

import com.example.pokemonapimvvmjetpackcompose.data.API.APIDetails.POKEMON_DETAIL_ENDPOINT
import com.example.pokemonapimvvmjetpackcompose.data.model.Pokemon
import com.example.pokemonapimvvmjetpackcompose.data.model.PokemonList
import com.example.pokemonapimvvmjetpackcompose.data.resource.Resource
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonRepository {

    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Resource<PokemonList>

    @GET(POKEMON_DETAIL_ENDPOINT)
    suspend fun getPokemonInfo(
        @Path("name") pokemonName:String
    ): Resource<Pokemon>
}