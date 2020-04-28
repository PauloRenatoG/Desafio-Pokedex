package com.example.desafiopokedex.view.listpokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemPokemonBinding
import com.example.desafiopokedex.util.loadImage
import com.example.domain.entity.ListNameSprite

class ListPokemonViewHolder(
    private val binding: ItemPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(result: ListNameSprite) {
        with(binding) {
            textName.text = result.name
            imagePokemon.loadImage(result.sprites?.frontDefault)
        }
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