package com.example.desafiopokedex.view.pokemondetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemPokemonSpriteBinding
import com.example.desafiopokedex.util.loadImage

class PokemonDetailViewHolder(
    private val binding: ItemPokemonSpriteBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(sprite: String) {
        binding.imagePokemon.loadImage(sprite)
    }

    companion object {
        fun inflate(parent: ViewGroup): PokemonDetailViewHolder {
            return PokemonDetailViewHolder(
                ItemPokemonSpriteBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}