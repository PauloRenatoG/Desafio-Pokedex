package com.example.desafiopokedex.view.pokemondetail.recyclersprites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemPokemonSpriteBinding
import com.example.desafiopokedex.util.loadImage

class PokemonSpriteViewHolder(
    private val binding: ItemPokemonSpriteBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(sprite: String) {
        binding.imagePokemon.loadImage(sprite)
    }

    companion object {
        fun inflate(parent: ViewGroup): PokemonSpriteViewHolder {
            return PokemonSpriteViewHolder(
                ItemPokemonSpriteBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}