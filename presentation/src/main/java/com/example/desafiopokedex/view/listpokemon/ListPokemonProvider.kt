package com.example.desafiopokedex.view.listpokemon

import androidx.lifecycle.ViewModel
import com.example.desafiopokedex.graph.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListPokemonProvider {

    @Binds
    @IntoMap
    @ViewModelKey(ListPokemonViewModel::class)
    abstract fun bindsListPokemonViewModel(viewModel: ListPokemonViewModel): ViewModel
}