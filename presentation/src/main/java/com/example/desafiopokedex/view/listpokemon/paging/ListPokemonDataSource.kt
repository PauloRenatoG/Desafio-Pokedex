package com.example.desafiopokedex.view.listpokemon.paging

import androidx.paging.PageKeyedDataSource
import com.example.domain.entity.Result
import com.example.domain.usecase.GetListPokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ListPokemonDataSource(
    private val getList: GetListPokemon,
    private val scope: CoroutineScope,
    private val onFailure: ((Throwable) -> Unit)? = null
) : PageKeyedDataSource<Int, Result>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        scope.launch {
            runCatching {
                getList.execute(0, params.requestedLoadSize)
            }.onSuccess { response ->
                response?.results?.let {
                    callback.onResult(it, null, 1)
                }
            }.onFailure {
                onFailure?.invoke(it)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        scope.launch {
            runCatching {
                getList.execute(params.key, params.requestedLoadSize)
            }.onSuccess { response ->
                response?.results?.let {
                    callback.onResult(it, params.key + 1)
                }
            }.onFailure {
                onFailure?.invoke(it)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        scope.launch {
            runCatching {
                getList.execute(params.key, params.requestedLoadSize)
            }.onSuccess { response ->
                response?.results?.let {
                    callback.onResult(it, params.key - 1)
                }
            }.onFailure {
                onFailure?.invoke(it)
            }
        }
    }
}