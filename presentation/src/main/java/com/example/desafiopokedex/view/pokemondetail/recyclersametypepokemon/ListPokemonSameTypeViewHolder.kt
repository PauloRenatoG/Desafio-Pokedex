package com.example.desafiopokedex.view.pokemondetail.recyclersametypepokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemListPokemonTypeBinding
import com.example.domain.entity.Pokemon

class ListPokemonSameTypeViewHolder(
    private val binding: ItemListPokemonTypeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemonType: Pokemon) {
        binding.textName.text = pokemonType.pokemon?.name
    }

    companion object {
        fun inflate(parent: ViewGroup): ListPokemonSameTypeViewHolder {
            return ListPokemonSameTypeViewHolder(
                ItemListPokemonTypeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}