package com.example.desafiopokedex.view.listpokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemPokemonBinding
import com.example.domain.entity.Result

class ListPokemonViewHolder(
    private val binding: ItemPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(result: Result) {
        binding.textName.text = result.name
    }

    companion object {
        fun inflate(parent: ViewGroup): ListPokemonViewHolder {
            return ListPokemonViewHolder(
                ItemPokemonBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}