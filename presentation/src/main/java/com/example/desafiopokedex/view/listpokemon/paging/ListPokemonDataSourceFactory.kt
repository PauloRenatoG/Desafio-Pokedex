package com.example.desafiopokedex.view.listpokemon.paging

import androidx.paging.DataSource
import com.example.domain.entity.Result
import com.example.domain.usecase.GetListPokemon
import kotlinx.coroutines.CoroutineScope

class ListPokemonDataSourceFactory(
    private val getList: GetListPokemon,
    private val scope: CoroutineScope,
    private val onFailure: ((Throwable) -> Unit)? = null
) : DataSource.Factory<Int, Result>() {
    override fun create(): DataSource<Int, Result> {
        return ListPokemonDataSource(
            getList,
            scope,
            onFailure
        )
    }
}