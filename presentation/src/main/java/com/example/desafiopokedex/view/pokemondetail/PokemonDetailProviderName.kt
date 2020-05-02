package com.example.desafiopokedex.view.pokemondetail

import com.example.desafiopokedex.util.NAME_POKEMON
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class PokemonDetailProviderName {
    @Provides
    @Named(NAME_POKEMON)
    fun bindsPokemonName(fragment: PokemonDetailFragment): String {
        return fragment.name
    }
}