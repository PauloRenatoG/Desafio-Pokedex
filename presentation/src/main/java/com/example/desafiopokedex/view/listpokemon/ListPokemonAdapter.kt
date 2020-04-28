package com.example.desafiopokedex.view.listpokemon

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.Result

class ListPokemonAdapter : PagedListAdapter<Result, ListPokemonViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPokemonViewHolder {
        return ListPokemonViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: ListPokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.bindData(it) }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }
}