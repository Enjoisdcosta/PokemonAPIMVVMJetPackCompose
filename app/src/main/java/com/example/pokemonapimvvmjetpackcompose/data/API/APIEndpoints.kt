package com.example.pokemonapimvvmjetpackcompose.data.API

import com.example.pokemonapimvvmjetpackcompose.data.API.APIDetails.POKEMON_DETAIL_ENDPOINT
import com.example.pokemonapimvvmjetpackcompose.data.API.APIDetails.POKEMON_ENDPOINT
import com.example.pokemonapimvvmjetpackcompose.data.model.Pokemon
import com.example.pokemonapimvvmjetpackcompose.data.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface APIEndpoints {

    @GET(POKEMON_ENDPOINT)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ):PokemonList

    @GET(POKEMON_DETAIL_ENDPOINT)
    suspend fun getPokemonInfo(
        @Path("name") name:String
    ): Pokemon
}