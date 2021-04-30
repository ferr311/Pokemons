package com.example.pokemons.repository

import com.example.pokemons.data.remote.PokemonApi
import com.example.pokemons.data.remote.response.Pokemon
import com.example.pokemons.data.remote.response.PokemonList
import com.example.pokemons.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val api: PokemonApi) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (e: Exception) {
            return Resource.Error("Unexpected error")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name = name)
        } catch (e: Exception) {
            return Resource.Error("Some error")
        }
        return Resource.Success(response)
    }

}