package com.example.desafiopokedex.view.listpokemon.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.domain.entity.ListNameSprite
import com.example.domain.entity.Result
import com.example.domain.usecase.GetListPokemon
import com.example.domain.usecase.GetSprites
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ListPokemonDataSource(
    private val getList: GetListPokemon,
    private val getSprites: GetSprites,
    private val loadingProgressBar: MutableLiveData<Boolean>,
    private val scope: CoroutineScope,
    private val onFailure: ((Throwable) -> Unit)? = null
) : PageKeyedDataSource<Int, ListNameSprite>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ListNameSprite>
    ) {
        scope.launch {
            runCatching {
                loadingProgressBar.postValue(true)
                getList.execute(0, params.requestedLoadSize)
            }.onSuccess { response ->
                response?.results?.let {
                    callback.onResult(zipResultSprites(it), null, 1)
                }
            }.onFailure {
                onFailure?.invoke(it)
                loadingProgressBar.postValue(false)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ListNameSprite>) {
        scope.launch {
            runCatching {
                loadingProgressBar.postValue(true)
                getList.execute(params.key * params.requestedLoadSize, params.requestedLoadSize)
            }.onSuccess { response ->
                response?.results?.let {
                    callback.onResult(
                        zipResultSprites(it),
                        params.key + 1
                    )
                }
            }.onFailure {
                onFailure?.invoke(it)
                loadingProgressBar.postValue(false)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ListNameSprite>) {
        scope.launch {
            runCatching {
                loadingProgressBar.postValue(true)
                getList.execute(params.key * params.requestedLoadSize, params.requestedLoadSize)
            }.onSuccess { response ->
                response?.results?.let {
                    callback.onResult(zipResultSprites(it), (params.key - 1))
                }
            }.onFailure {
                onFailure?.invoke(it)
                loadingProgressBar.postValue(false)
            }
        }
    }

    private suspend fun zipResultSprites(results: List<Result>): List<ListNameSprite> {
        val list = mutableListOf<ListNameSprite>()
        results.forEach { result ->
            runCatching {
                result.name?.let { namePokemon -> getSprites.execute(namePokemon) }
            }.onSuccess { response ->
                list.add(ListNameSprite(name = result.name, url = result.url, sprites = response))
            }.onFailure {
                onFailure?.invoke(it)
            }
        }
        loadingProgressBar.postValue(false)
        return list
    }
}