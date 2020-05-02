package com.example.desafiopokedex.view.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.desafiopokedex.graph.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PokemonDetailProvider {
    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailViewModel::class)
    abstract fun bindsPokemonDetailViewModel(viewModel: PokemonDetailViewModel): ViewModel
}