package com.example.desafiopokedex.view.pokemondetail.recyclersprites

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonSpriteAdapter(
    private val listSprites: List<String>
) : RecyclerView.Adapter<PokemonSpriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonSpriteViewHolder {
        return PokemonSpriteViewHolder.inflate(
            parent
        )
    }

    override fun onBindViewHolder(holder: PokemonSpriteViewHolder, position: Int) {
        holder.bind(listSprites[position])
    }

    override fun getItemCount() = listSprites.size

}