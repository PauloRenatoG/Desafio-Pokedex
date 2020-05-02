package com.example.desafiopokedex.graph.module

import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.*
import com.example.desafiopokedex.view.base.ViewModelFactory
import com.example.domain.repository.*
import dagger.Binds
import dagger.Module

@Module
interface ApplicationBindModule {

    @Binds
    fun bindsGetListResultRepository(repository: GetListResultRepositoryImpl): GetListResultRepository

    @Binds
    fun bindsGetSpritesRepository(repository: GetSpritesRepositoryImpl): GetSpritesRepository

    @Binds
    fun bindsGetPokemonDetailRepository(repository: GetPokemonDetailRepositoryImpl): GetPokemonDetailRepository

    @Binds
    fun bindsGetAbilityRepository(repository: GetAbilityRepositoryImpl): GetAbilityRepository

    @Binds
    fun bindsGetSamePokemonTypeRepository(repository: GetSamePokemonTypeRepositoryImpl): GetSamePokemonTypeRepository

    @Binds
    fun bindsGetEvolutionRepository(repository: GetEvolutionRepositoryImpl): GetEvolutionRepository

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}