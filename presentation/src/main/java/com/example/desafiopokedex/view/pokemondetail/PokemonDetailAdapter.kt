package com.example.desafiopokedex.view.pokemondetail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonDetailAdapter(
    private val listSprites: List<String>
) : RecyclerView.Adapter<PokemonDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonDetailViewHolder {
        return PokemonDetailViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: PokemonDetailViewHolder, position: Int) {
        holder.bind(listSprites[position])
    }

    override fun getItemCount() = listSprites.size

}