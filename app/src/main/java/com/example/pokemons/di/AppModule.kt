package com.example.pokemons.di

import com.example.pokemons.data.remote.PokemonApi
import com.example.pokemons.data.remote.PokemonApi.Companion.BASE_URL
import com.example.pokemons.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonRepo(api: PokemonApi): PokemonRepository = PokemonRepository(api = api)

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokemonApi::class.java)

}