package com.example.desafiopokedex.view.pokemondetail.recyclerability

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemPokemonAbilityBinding

class PokemonAbilityAndTypeViewHolder(
    private val binding: ItemPokemonAbilityBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(name: String) {
        binding.chipAbility.text = name
    }

    companion object {
        fun inflate(parent: ViewGroup): PokemonAbilityAndTypeViewHolder {
            return PokemonAbilityAndTypeViewHolder(
                ItemPokemonAbilityBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}