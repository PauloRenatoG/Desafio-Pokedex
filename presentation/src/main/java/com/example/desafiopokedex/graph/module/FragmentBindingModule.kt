package com.example.desafiopokedex.graph.module

import com.example.desafiopokedex.graph.scope.FragmentScope
import com.example.desafiopokedex.view.listpokemon.ListPokemonFragment
import com.example.desafiopokedex.view.listpokemon.ListPokemonProvider
import com.example.desafiopokedex.view.pokemondetail.PokemonDetailFragment
import com.example.desafiopokedex.view.pokemondetail.PokemonDetailProvider
import com.example.desafiopokedex.view.pokemondetail.PokemonDetailProviderName
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ListPokemonProvider::class])
    fun contributeListPokemonFragment(): ListPokemonFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PokemonDetailProvider::class, PokemonDetailProviderName::class])
    fun contributePokemonDetailFragment(): PokemonDetailFragment
}