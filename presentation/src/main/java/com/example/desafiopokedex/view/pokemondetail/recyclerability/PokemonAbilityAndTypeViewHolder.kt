package com.example.desafiopokedex.view.pokemondetail.recyclerability

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemPokemonAbilityBinding

class PokemonAbilityAndTypeViewHolder(
    private val binding: ItemPokemonAbilityBinding,
    private val callbackClicked: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(name: String) {
        binding.chipAbility.text = name
        binding.chipAbility.setOnClickListener {
            callbackClicked.invoke(name)
        }
    }

    companion object {
        fun inflate(
            parent: ViewGroup,
            callbackClicked: (String) -> Unit
        ): PokemonAbilityAndTypeViewHolder {
            return PokemonAbilityAndTypeViewHolder(
                ItemPokemonAbilityBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                callbackClicked
            )
        }
    }
}