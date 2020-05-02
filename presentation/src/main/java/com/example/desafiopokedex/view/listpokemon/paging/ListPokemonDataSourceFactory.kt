package com.example.desafiopokedex.view.listpokemon.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.domain.entity.ListNameSprite
import com.example.domain.usecase.GetListPokemon
import com.example.domain.usecase.GetSprites
import kotlinx.coroutines.CoroutineScope

class ListPokemonDataSourceFactory(
    private val getList: GetListPokemon,
    private val getSprites: GetSprites,
    private val loadingProgressBar: MutableLiveData<Boolean>,
    private val scope: CoroutineScope,
    private val onFailure: ((Throwable) -> Unit)? = null
) : DataSource.Factory<Int, ListNameSprite>() {
    override fun create(): DataSource<Int, ListNameSprite> {
        return ListPokemonDataSource(
            getList,
            getSprites,
            loadingProgressBar,
            scope,
            onFailure
        )
    }
}