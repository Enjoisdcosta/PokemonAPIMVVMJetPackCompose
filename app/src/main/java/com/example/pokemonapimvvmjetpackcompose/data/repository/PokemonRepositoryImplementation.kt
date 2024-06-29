package com.example.pokemonapimvvmjetpackcompose.data.repository

import com.example.pokemonapimvvmjetpackcompose.data.API.APIEndpoints
import com.example.pokemonapimvvmjetpackcompose.data.model.Pokemon
import com.example.pokemonapimvvmjetpackcompose.data.model.PokemonList
import com.example.pokemonapimvvmjetpackcompose.data.resource.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImplementation @Inject constructor(
    private val apiDetail: APIEndpoints
): PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try{
            apiDetail.getPokemonList(limit, offset)
        } catch (e: Exception){
            return Resource.Error("An unknown error occured")

        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try{
            apiDetail.getPokemonInfo(pokemonName)
        } catch (e: Exception){
            return Resource.Error("An unknown error occured")

        }
        return Resource.Success(response)
    }
}