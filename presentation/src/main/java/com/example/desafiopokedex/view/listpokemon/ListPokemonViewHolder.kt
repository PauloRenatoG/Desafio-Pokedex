package com.example.desafiopokedex.view.listpokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopokedex.databinding.ItemPokemonBinding
import com.example.desafiopokedex.util.loadImage
import com.example.domain.entity.ListNameSprite

class ListPokemonViewHolder(
    private val binding: ItemPokemonBinding,
    private val callBackClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(result: ListNameSprite) {
        with(binding) {
            textName.text = result.name
            imagePokemon.loadImage(result.sprites?.frontDefault)
            itemPokemon.setOnClickListener {
                result.name?.let { callBackClick.invoke(it) }
            }
        }

    }

    companion object {
        fun inflate(parent: ViewGroup, callBackClick: (String) -> Unit): ListPokemonViewHolder {
            return ListPokemonViewHolder(
                ItemPokemonBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                callBackClick
            )
        }
    }
}