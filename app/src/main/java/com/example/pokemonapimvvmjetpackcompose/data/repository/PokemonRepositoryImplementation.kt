package com.example.pokemonapimvvmjetpackcompose.data.repository

import com.example.pokemonapimvvmjetpackcompose.data.API.APIEndpoints
import com.example.pokemonapimvvmjetpackcompose.data.model.Pokemon
import com.example.pokemonapimvvmjetpackcompose.data.model.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImplementation @Inject constructor(
    private val apiDetail: APIEndpoints
): PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonList {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonInfo(name: String): Pokemon {
        TODO("Not yet implemented")
    }
}