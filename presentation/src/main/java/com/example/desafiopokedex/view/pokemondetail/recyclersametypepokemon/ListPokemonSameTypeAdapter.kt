package com.example.desafiopokedex.view.pokemondetail.recyclersametypepokemon

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Pokemon

class ListPokemonSameTypeAdapter(
    private val listPokemon: List<Pokemon>?
) : RecyclerView.Adapter<ListPokemonSameTypeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListPokemonSameTypeViewHolder {
        return ListPokemonSameTypeViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: ListPokemonSameTypeViewHolder, position: Int) {
        listPokemon?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount() = listPokemon?.size ?: 0
}