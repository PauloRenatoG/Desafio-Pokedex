package com.example.desafiopokedex.view.listpokemon

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.ListNameSprite

class ListPokemonAdapter(
    private val callBackClick: (String) -> Unit
) : PagedListAdapter<ListNameSprite, ListPokemonViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPokemonViewHolder {
        return ListPokemonViewHolder.inflate(parent, callBackClick)
    }

    override fun onBindViewHolder(holder: ListPokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.bindData(it) }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListNameSprite>() {
            override fun areItemsTheSame(
                oldItem: ListNameSprite,
                newItem: ListNameSprite
            ): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(
                oldItem: ListNameSprite,
                newItem: ListNameSprite
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}