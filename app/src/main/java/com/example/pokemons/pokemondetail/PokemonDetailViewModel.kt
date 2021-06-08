package com.example.pokemons.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pokemons.data.remote.PokemonApi
import com.example.pokemons.data.remote.response.Pokemon
import com.example.pokemons.repository.PokemonRepository
import com.example.pokemons.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repo: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        return repo.getPokemonInfo(name = name)
    }
}