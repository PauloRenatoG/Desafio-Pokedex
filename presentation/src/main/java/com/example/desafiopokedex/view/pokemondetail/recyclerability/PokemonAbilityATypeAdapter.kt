package com.example.desafiopokedex.view.pokemondetail.recyclerability

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonAbilityATypeAdapter(
    private val list: List<String?>?
) : RecyclerView.Adapter<PokemonAbilityAndTypeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonAbilityAndTypeViewHolder {
        return PokemonAbilityAndTypeViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: PokemonAbilityAndTypeViewHolder, position: Int) {
        list?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount() = list?.size ?: 0
}